# Android-Testing-Demo

This is a demo to show UI tesing using Robolectric and unit testing using mockito.The presentation classes will be in the app module and 
the test cases will be done using Roblectric. While the business logic classes will be in a domain layer to separate concerns; those 
test cases meant to test those classes will be using mockito and Junit.

Here I demonstrate how to use Robolectric and Junit to test the UI components and some of their behaviors. For instance the performClick tests the button and if the event is triggered properly and if it handles empty string in this case. The test fails if there is no empty string handling mechanism in any way. 
