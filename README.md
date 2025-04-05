# Spring-Cloud-Distributed-Microservices-Application
This repository contains the implementation of a distributed microservices system developed for Homework 2 of the Distributed Systems course at Vilnius Gediminas Technical University.

📘 Project Overview
This project demonstrates a microservices architecture using Spring Cloud, with a focus on service discovery, centralized configuration, and client-side load balancing. The system consists of the following modules:

discovery-service
A Eureka Server that handles service registration and discovery for all microservices in the system.

config-server
A Spring Cloud Config Server that provides centralized and version-controlled configuration for other services.

microservice
A service adapted from Homework 1, used for managing library-related operations. Multiple instances of this microservice can be launched to demonstrate load balancing.

load-balancer
A dedicated client-side load balancer application that uses Spring Cloud OpenFeign (@FeignClient) to make requests to multiple running instances of the microservice. Eureka handles service discovery, and Feign ensures load is distributed across instances using round-robin or other built-in strategies.

🚀 Prerequisites
Make sure the following tools are installed on your system:

Java 21

Maven

Git

