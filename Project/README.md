# Project Report: CPC_jobApp

## Introduction:

When you graduated and looking for job to stay alive in this world. Then you might have tried sending different emails along with CV for applying on the job. Are you tired of not getting proper response? The CPC_jobApp is here to solve this problem of finding the job to an easier solution through an app. In this Android mobile application, a student from the North South University who is a graduate or still in study phase looking for a job will be able to find jobs through this app. This android platform job application will allow the students to apply for the job through the CV and get the job advertisement in their home fragment and can choose from there. 


## Design pattern:
This app was based on the Model-View-ViewModel(MVVM) layout. 
In this project the Models are stored on the entity class folder. The View are stored in the UIController and the layout file of the project. The ViewModel is in the adapter class folder. RecyclerView includes a new kind of adapter. It’s a similar approach to the ones you already used, but with some peculiarities, such as a required ViewHolder. You will have to override two main methods: one to inflate the view and its view holder, and another one to bind data to the view. The good thing about this is that the first method is called only when we really need to create a new view. No need to check if it’s being recycled.
The design pattern:
![MVVM](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/MVVM.JPG)


The Following are the snapshots of the project:

![splash](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623063996.png)

![login](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064015.png)

![register](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064030.png)

![addstudent](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064043.png)

![StudentReg](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064053.png)

![StudentLogin](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064080.png)

![StudentDash](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064093.png)

![addrecord](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064109.png)

![addjobs](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/Screenshot_1623064166.png)

## Data management:
The database is managed through the DAO format in the local room database. For the login and registration, remote Firebase authentication login is used. By this way many user from different places can access and login the app.
The data are stored in separate tables. One for the Students who are the Students and other is for the companies who will be able to post jobs.
The Firebase Realtime database is used for storing the datas.
The following screenshot shows the pattern of how the datas are stored.
### Firebase Authentication
![Firebase](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/FirebaseUsers.JPG)
### Realtime Database
![Realtime](https://github.com/NSU-SP21-CSE486-1/1431000-SP21-CSE486-S01/blob/5e1deaaa68711a5ae157b990e0b00d3564dc5910/Project/RealtimeDB.JPG)


## Road Blocks:
Coding for the first time in the Android app development was a major drawback for me at the beginning. Having issues with the database implementations with the whole project was a hassle for sure. For the layout of the project using the Relative and Constraints layout individually for different pages made it difficult to make the fragment pages in alignment.

The very important issue I faced was the implementing the Firebase Realtime Database. As the rules were chosed as _read/write_ as false. Another roadblock for this project is retrieving the data from the cloud Firebase to recyclerview. 
The Child class of the firebase is not supporting the cardview in the design layout.

## Improvements for the future:
This project will be improved for a further better and user friendly UX design. This little unfinished project will be able to implement more features like adding profile picture, joining the database with more advanced databases. More secured user authentication and better handling of the datas in the cloud database.

## Conclusion:
Through this java language based Android project, I tried to implement a system where the job seekers can search for students from the North South University. And for the students it will be easier for them to search for the jobs with ease with this app.

 
