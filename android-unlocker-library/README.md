# Gradle import Android Unlocker Library

Automatic import the Files and Directory of *Android Unlocker Library*.

Open the **build.gradle** file of your Module-Directory of the Free and Pro-App.

Added under this line **apply plugin: 'com.android.application'**

    apply from: 'https://raw.githubusercontent.com/Ludy87/gradle/master/android-unlocker-library/loader.gradle'

and in the *defaultConfig* under *applicationId*

Pro-App
===

    manifestPlaceholders = [unlock: "YOUR_UNIQUE_PERMISSION_NAME"]
    project.downloadLibFiles(applicationId, manifestPlaceholders.unlock)
    project.unlock()

**Result:**

    apply plugin: 'com.android.application'

    apply from: 'https://raw.githubusercontent.com/Ludy87/gradle/master/android-unlocker-library/loader.gradle'

    android {
    
        defaultConfig {
            applicationId "YOUR_PROJECT_PRO"
            manifestPlaceholders = [unlock: "YOUR_UNIQUE_PERMISSION_NAME"]
            project.downloadLibFiles(applicationId, manifestPlaceholders.unlock)
            project.unlock()
    ...

Free-App
===

    manifestPlaceholders = [lock: "YOUR_UNIQUE_PERMISSION_NAME"]
    project.downloadLibFiles(applicationId, manifestPlaceholders.lock)
    project.lock()

**Result:**

    apply plugin: 'com.android.application'

    apply from: 'https://raw.githubusercontent.com/Ludy87/gradle/master/android-unlocker-library/loader.gradle'

    android {
    
        defaultConfig {
            applicationId "YOUR_PROJECT_FREE"
            manifestPlaceholders = [lock: "YOUR_UNIQUE_PERMISSION_NAME"]
            project.downloadLibFiles(applicationId, manifestPlaceholders.lock)
            project.lock()
    ...
            
----
After the synchronization, your will be the Androidmanifest.xml changes and the library file is downloaded.

License
-------

    Copyright [2016] [Ludy]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
----

[Copyright 2013 Vincent Mimoun-Prat](https://github.com/marvinlabs/android-unlocker-library)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
