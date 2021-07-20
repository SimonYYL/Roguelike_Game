# My Personal Project:  *Roguelike Game*

## Project Description 

###Background and ideas
My inspiration came from famous role-playing video game subgenre called: *Roguelike*. 
The core gameplay such as: characters exploring dungeons and fighting monsters and 
the characteristics that characters cannot be resurrected after death are retained in my project.  


###New content
A team mechanism has been added to my project, that is, players (users) can create a heroe to form a team 
with up to four heroes to challenge monsters together.Taking into account the difficulty of production and potential 
art-related work, my project will not include maps.

###Detailed description
My project is a simplified **role-playing** game. In the game, the player (user) will create 4 heroes to form a team to 
challenge monster. Killing monsters is victory and you can get corresponding treasures. Each hero has the following 
attributes:
- health
- attack power
- level
- name
- occupation
- accuracy

Each monster has the following attributes:

- health
- attack power
- name 
  
During the battle, the health of heroes and monsters is calculated through battle algorithms. 
When the health value of a hero or monster is cleared(reach 0), it is judged as dead. <span style="color:red">
Warning: Heroes cannot be resurrected from death. Please use your hero wisely. </span> 
The game ends when all the available heroes die (LOST) or  monsters die (VICTORY).

###For users
This project is presented to users who have played Roguelike as a child or those who are interested in this game theme. 
By playing my project, users (players) may recall good memories from childhood or have a deeper understanding 
of Roguelike games. Bringing happiness to players (users) is the purpose of this project. Those who want to experience 
exciting adventures are the audience of this project. 

<span style="font-family:Papyrus; font-size:4em;">The Dungeon is Calling You</span>


##Words from the developers
I like playing games. I spent a lot of time playing games like CSGO and Escap from Tarkov. 
When I gradually realized that I could also start to create some games of my own, I was very excited. 
Through the content I learned in the CPSC210 course, I am able to write my thoughts, understandings, and stories into 
the code and present them to others to experience, which in itself is something I am interested in.

##User Stories
1. As a user, I want to be able to add a hero into battle-team.
1. As a user, I want to be able to view the list of hero in battle-team.
1. As a user, I want to be able to create a hero.
1. As a user, I want to be able to make hero fight the monster.

##Phase 4: Task 2:
1. I build an exception called Monster Already Gone Exception which indicate the monster is already dead. Since there 
could be a situation that monster and hero both dead after a round of fight, I personally decide this will be regard 
as a win for heroes. I wrote tests for this exception in Battle Test class under test package.
   
##Phase 4: Task 3:
The UML class diagram is in the root package under the README file. Please check.