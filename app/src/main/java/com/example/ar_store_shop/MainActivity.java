package com.example.ar_store_shop;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;

    Button back,cart;
    ArFragment arFragment;
    ModelRenderable lampPostRenderable;
    String item;
    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//get intent from ItemActivity about which item is selected
        Intent i = getIntent();
        item = i.getStringExtra("Selected Item");

        String item_name;
        if(item.equals("Arm Chair"))
        {
            item_name = "ARMCHAIR.sfb";
        }
        else if(item.equals("Chair"))
        {
            item_name = "chair.sfb";
        }
        else if(item.equals("Cycle"))
        {
            item_name = "roadBike.sfb";
        }
        else if(item.equals("Ficus Plant"))
        {
            item_name = "ficus.sfb";
        }
        else if(item.equals("Living room Lamp"))
        {
            item_name = "living_lamp.sfb";
        }

        else if(item.equals("Antique Sofa"))
        {
            item_name = "settie-sofa.sfb";
        }
        else if(item.equals("Tulip Vase"))
        {
            item_name = "flowers.sfb";
        }
        else if(item.equals("Wooden Coffee Table"))
        {
            item_name = "wooden-coffe-table.sfb";
        }

        else
        {
            item_name = "CruzV2.sfb";
        }


        if (!checkIsSupportedDeviceOrFinish(this)) {
            return;
        }
        setContentView(R.layout.activity_main);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        ModelRenderable.builder()
                .setSource(this, Uri.parse(item_name))
                .build()
                .thenAccept(renderable -> lampPostRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast toast = Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return null;
                });


        arFragment.setOnTapArPlaneListener(
                (HitResult hitresult, Plane plane, MotionEvent motionevent) -> {
                    if (lampPostRenderable == null){
                        return;
                    }
                    Anchor anchor = hitresult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());
                    TransformableNode lamp = new TransformableNode(arFragment.getTransformationSystem());
                    //Resize the image
                    lamp.getScaleController().setMaxScale(0.55f);
                    lamp.getScaleController().setMinScale(0.10f);
                    lamp.setParent(anchorNode);
                    lamp.setRenderable(lampPostRenderable);
                    lamp.select();
                }


        );





    }
    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }

    private void initializeViews() {
        back = findViewById(R.id.back);
        cart = findViewById(R.id.cart);
    }

    public void backtoItem(View view) {
        Intent i = new Intent(getApplicationContext(), ItemActivity.class);
        startActivity(i);
    }

    public void addtoCart(View view) {

        Intent i = new Intent(getApplicationContext(), CartActivity.class);
        //String item = i.getStringExtra("Selected Item");
        i.putExtra("Selected Item", item);
        startActivity(i);
    }



}