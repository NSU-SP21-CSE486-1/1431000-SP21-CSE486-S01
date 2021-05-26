# Project Report: CPC_jobApp

## Introduction:

When you graduated and looking for job to stay alive in this world. Then you might have tried sending different emails along with CV for applying on the job. Are you tired of not getting proper response? The CPC_jobApp is here to solve this problem of finding the job to an easier solution through an app. In this Android mobile application, a student from the North South University who is a graduate or still in study phase looking for a job will be able to find jobs through this app. This android platform job application will allow the students to apply for the job through the CV and get the job advertisement in their home fragment and can choose from there. 


## Design pattern:
This app was based on the Model-View-ViewModel(MVVM) layout. 
In this project the Models are stored on the entity class folder. The View are stored in the UIController and the layout file of the project. The ViewModel is in the adapter class folder. RecyclerView includes a new kind of adapter. It’s a similar approach to the ones you already used, but with some peculiarities, such as a required ViewHolder. You will have to override two main methods: one to inflate the view and its view holder, and another one to bind data to the view. The good thing about this is that the first method is called only when we really need to create a new view. No need to check if it’s being recycled.

The following image describes about the structure of the project in MVVM format:
![MVVM](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/957fe192554cbb2e9e2bb3a6632b0cf8df286368/Project/MVVM.jpg)


The Following are the snapshots of the project:

![splash](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/07159905b4107e396805e200172ea62db59b12af/Project/splashscreen.JPG)

![login](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/07159905b4107e396805e200172ea62db59b12af/Project/login.JPG)

![register](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/07159905b4107e396805e200172ea62db59b12af/Project/register.JPG)

![addstudent](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/07159905b4107e396805e200172ea62db59b12af/Project/addstudent.JPG)

![addjob](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/07159905b4107e396805e200172ea62db59b12af/Project/addjob.JPG)

## Data management:
The database is managed through the DAO format in the local room database. For the login and registration, remote Firebase authentication login is used. By this way many user from different places can access and login the app. 
The data are stored in separate tables. One for the Students who are the user and other is for the companies who will be able to post jobs.


## Road Blocks:
Coding for the first time in the Android app development was a major drawback for me at the beginning. Having issues with the database implementations with the whole project was a hassle for sure. For the layout of the project using the Relative and Constraints layout individually for different pages made it difficult to make the fragment pages in alignment.

 
