## The Elephant  ##
Sample app that show the list of elephants and their informations.

### Architecture ###
MVVM and Clean Architecture
 - MVVM pattern separate view from the business logic.
- Kotlin DSL Plugin.
    - Plugin to extend projects capabilities, can do such as apply specific configuration, reuse and reduct the overhead of maintaining gradle projects.
    - I used kotlin dsl plugin to manage my dependencies and configurations for both app and library module and also it helps to lessen the process of gradle.

#### Folder Structure ####

**Presentation Layer** - presents data to a screen and handle user interactions.
- android
    - app
    - core
    - feature
	- feature
	- feature

**buildSrc** - Is responsible to share all dependencies and configurations for both app and library modules.

**Data Layer** - Is responsible for all repositories, Data layer exposes a data source API to outside classes.

**Domain Layer** - Is responsible of implementing the business logic, rules, and requirements.

## APP PREVIEW ##
<img src="https://github.com/benidict1995/the-elephant/blob/master/demo/demo1.gif" alt="alt text" width="360dp" height="640dp"></br>
<img src="https://github.com/benidict1995/the-elephant/blob/master/demo/demo2.gif" alt="alt text" width="360dp" height="640dp">

## API SOURCE ##
Thanks to [Elephant API](https://elephant-api.herokuapp.com/?ref=public-apis) for the publication of free api.
    
## Author ##
Benidict Dulce - @benidict1995 on GitHub.
 ## References: ##
https://docs.gradle.org/current/userguide/kotlin_dsl.html</br>
https://docs.gradle.org/current/userguide/publishing_ivy.html</br>
https://elephant-api.herokuapp.com/?ref=public-apis

 
 
 
 
