# Connect Five Server

## Introduction
This repository contains the server side implementation of a connect five game. This was written as part of an interview coding challenge for Genesys.

## Technology
The application is simple and uses spring-boot-web-starter as a means to provide a server that exposes REST endpoints to a client for interaction. The game logic is implemented on ther server side. There is no persistency present apart from a singleton instance of a class that encapsulates the game's state.

## Design
The game revolves around two primary entities that have been modeled. The GameBoard and the Player. Both of these types encapsulate the necessary information and actions necessary to play the game. The game's state is stored in a GameState class which implements the singleton design pattern. This state object contains instances of both the GameBoard and Players. 

interaction with the gameboard is made possible through the singleton state object (eg. a player making a move)

The REST endpoints expose these operations to the client who can then read from the state object or attempt to modify it.

## Building and Running the application
To run the ConnectFive backend

1. Clone the Repository
   ```
   $ git clone https://github.com/Eogcloud/ConnectFiveServer.git
   ```
2. Build an image out of the Dockerfile within the repository.
   ```
   $ docker build . -t connectfivebackend
   ```
3. Run the new image and expose the container ports for requests
   ```
   $ docker run connectfivebackend --rm -d -n connectfivebackend -p 8080:8080 
   ```