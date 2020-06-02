# AR Shop Store


Team Name: Transformers


1. Amrutha Singh B
2. Anvitha Jain
3. Poorva Agarwal
4. Snehal Yeole


### Architecture

* AR Shop Store is an Augmented Reality Shopping Application that enables the customer to envision the product closer to reality using Google AR Core - Google SceneForm.

* Authentication using Google Firebase and storage using Firebase Real-time database.

* Firebase inbuilt analytics to check the number of Users.

* Integrated with a user-friendly chat bot via Google DialogFlow.

* Optical Character Recognition [OCR] for the ease of payment. 

* Integrated with PayPal Sandbox.


![archi (3)](https://user-images.githubusercontent.com/42703827/57832696-1ccf5080-776d-11e9-84b2-5dc04c91c977.png)


### Image Rendering

![Picture1](https://user-images.githubusercontent.com/42703827/57832997-da5a4380-776d-11e9-8f8e-284c3081b2b0.png)


### Pre-Requisites: Android API 28 or Android Pi or higher.

## Setup and Run Instructions: 

1. Download AR-Core from Google Play Store.
2. Build the application on Android Studio.
3. Run the application. 


### Other Instructions: 

1. Following are the dependencies Required in the build.gradle (Module: app) file: 

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar']) </br>
    implementation 'com.android.support:appcompat-v7:28.0.0' </br>
    implementation 'com.android.support.constraint:constraint-layout:1.1.3' </br>
    implementation 'com.google.firebase:firebase-auth:16.0.3' </br>
    implementation 'com.google.firebase:firebase-database:16.0.1' </br>
    testImplementation 'junit:junit:4.12' </br>
    androidTestImplementation 'com.android.support.test:runner:1.0.2' </br>
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2' </br>
    implementation 'com.google.firebase:firebase-core:16.0.1' </br>
    implementation "com.google.ar.sceneform.ux:sceneform-ux:1.5.0" </br>
   //for paypal </br>
    implementation 'com.paypal.sdk:paypal-android-sdk:2.15.3' </br>
   //for text recognition using google ocr </br>
    implementation 'com.google.android.gms:play-services-vision:15.0.1' </br>
    implementation "com.google.android.gms:play-services-base:15.0.1" </br>
   //for items views </br>
    implementation 'com.android.support:recyclerview-v7:28.0.0' </br>
    implementation 'com.android.support:cardview-v7:28.0.0' </br>
    // for gif animation </br>
    compile 'pl.droidsonroids.gif:android-gif-drawable:1.2.3' </br>
}

2. Ensure that the AR images are present in the "sampledata" folder. 

3. Ensure that firebase is connected in Android Studio.

4. Ensure that the following permissions are present in the AndroidManifest.xml

 * INTERNET
 * CAMERA
 * ACCESS_NETWORK_STATE
 * WRITE_EXTERNAL_STORAGE
 * READ_EXTERNAL_STORAGE
