Container Kata
---

This project is here to provide you a workbase on containerization.

## Context

This repository contains two projects, one backend and one frontend. Together they form a `quote-picker` webapp. 

The frontend call the backend to get a list of quotes, quotes are sorted by different categories and belong to an external directory that the backend can read.

The frontend is designed to call the backend on different endpoint (see ./backend/README.md for details).

## Setup

You'll need an environment to run and build container. 

There is a lot of tool to build container image (docker, kaniko, nix, even puppet...) this repository is made to stay the most "tech' agnostic" as it can be.

But, if you are a beginner who wants to get a taste of container we recommand you to check on [Docker](https://docs.docker.com/get-started/get-docker/)

Once your environment setup, you can get a backend and frontend from this repository

## Exercice

Here are some exercices you can do with it to warm you up.

> As stated previously there is multiple ways to work with container so this repository won't provide any solution or hints for those exercices! 
> 
> You'll have to find your own way.

### Build your projects

You currently have a backend and a frontend.

- Build your frontend project using a container.
- Build your backend project using a container.

### Have your frontend communicate with your backend container

#### Run your backend

- Build a container image from your backend project
  - Don't forget that quotes are in an external directory and may need to be embed.
- Run that container.

Make sure you can call your container using http

- You can type its url in your web browser (check backend/README.md for endpoint)
- You can call it from any http request tool (postman, curl...)

#### Make your frontend call your backend container

Now that you're sure you container is up and running, setup your frontend app and have it communicating with your container.

- If you use the frontend you've built from previous exercice, you got a static website.
- Static website needs an http server to be served.
- Frontend site is calling url on its own host to prevent CrossDomainRequest, you'll have to find a way to proxy them to the backend container.

### Have your frontend run by a container

You have a backend in a container but a frontend running from your local computer.

Now we want backend and frontend run in two distinct containers and have them communicating together

- Build a container image from your frontend project
- Run that container

Make sure your frontend is up and running and communicating with your backend container.

## Possible evolution

This is just a sample of what you can do but this project can help you on other stuff, here is some example.

- Run frontend and backend containers on kubernetes (you can [install k3s](https://k3s.io/) to work on your local environment).
- Make a repository for `frontend` and `backend` (just make sure to keep the licence) and have them build / delivered in a github action.
- Get the api spec and quote files and code it in a way to get a Cloud Native image.
- Build your image with an other tool than docker (nix is a cool one).
