# InstaFram
An instalation framework mockup, done for our software design course.

## General Info
This project was an assigment for our Software Design course. It mimicks a installation builder,
offering great customization in building the installer itself.
After the process of "building your installer" is done, you can click on export to see how it would look and run.

**It does not actually install anything, you choose a file which you want to *install* and that file will be copied to 
the destination you chose.**


## Usage
The hierarchy of the installer is based on 3 levels.

* Project

  * Module

    * Parameter


### Project
This is your project, a game, some desktop application, whatever you want to ship as your product.
Projects contain modules and are nothing more than a package containing all the files you want to install divided 
into these modules, grouped into one package.

### Module
Modules represent an installer part, it represents a complete installable software product which you want to ship.  
*Imagine shipping a game, your game would be the first module while the second would be some dependency like DirectX.*  
Here you can select the files you wish to *install*. You can have as many modules as you like with an option to select which
ones you would like to export in the export dialog.

### Parameter
The building element of your modules, you can add parameters, each parameter can be added once per module with the exception of
custom created parameters.  

**List of parameters:**

- Author  
- Description  
- Desktop Shortcut  
- Logo  
- TOC  
- Version  
- Custom(Enables building a custom install page with textfields, checkboxes and labels.)  


## Login System
This projects features a simple nonencrypted text based login system. It has two types of users. 
- Regular User  
- Administrator  

Administrators have full control over the program, while regular users are limited to exporting and changing parameters, without
the ability to change any of the already built structure of the instalation(Adding modules, removing modules, adding a new project, etc..)  
You can only register as a regular user, to add an adminstrator you must add a line to the "userdata.txt" file in the following format:  
**username*;*password*;true*  
where *username* is your desired username, *password* your desired password and true/false determine if it's a adminstrator account or not.  
***Because this is a school project, you can login with the credentials "uros" for the username and "nikolic" for the password if you want
instant administrator access without the hassle of editing a text file.***









