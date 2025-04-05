# 📦 Spring Cloud Distributed Microservices Application

This repository contains the implementation of a distributed microservices system developed for **Homework 2** of the *Distributed Systems* course at **Vilnius Gediminas Technical University**.

---

## 📘 Project Overview

This project demonstrates a **Spring Cloud**-based microservices architecture, focusing on:

- **Service discovery**
- **Centralized configuration**
- **Client-side load balancing**

The system is composed of the following modules:

### 🔍 `discovery-service`
A **Netflix Eureka Server** responsible for service registration and discovery across the distributed system.

### ⚙️ `config-server`
A **Spring Cloud Config Server** that offers centralized, externalized, and version-controlled configuration for all services in the ecosystem.

### 📚 `microservice`
A library management service, adapted from **Homework 1**, designed to support multiple running instances for testing load balancing behavior.

### ⚖️ `load-balancer`
A client-side load balancing service using **Spring Cloud OpenFeign** (`@FeignClient`). It communicates with multiple instances of the `microservice`, automatically distributing requests using built-in load balancing strategies like round-robin, with service resolution handled by Eureka.

---

## 🚀 Prerequisites

Ensure you have the following tools installed:

- ☕ **Java 21**
- 🔧 **Maven**
- 🌿 **Git**

---

## 📊 Service Configuration

Below is the configuration table for each project in the system:

| 🧩 Service Name   | 🔌 Port(s)      | ⏱️ Startup Order |
|------------------|----------------|------------------|
| `config-server`  | 8888           | 1                |
| `eureka-server`  | 8761           | 2                |
| `pirmas-darbas`  | 8081, 8082     | 3                |
| `loadBalancer`   | 8080           | 4                |
| `git-repo`       | –              | –                |


