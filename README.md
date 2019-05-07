## LeapYears
[![Build Status](https://travis-ci.org/2019-SOW-DEV-003/LeapYears.svg?branch=master)](https://travis-ci.org/2019-SOW-DEV-003/LeapYears)
[![codecov](https://codecov.io/gh/2019-SOW-DEV-003/LeapYears/branch/master/graph/badge.svg)](https://codecov.io/gh/2019-SOW-DEV-003/LeapYears)

## Aim of this Project:

As a user, I want to know if a year is a leap year, So that I can plan for an extra day on February 29th during those years.

## Acceptance Criteria:
* All years divisible by 400 ARE leap years (so, for example, 2000 was indeed a leap year),
* All years divisible by 100 but not by 400 are NOT leap years (so, for example, 1700, 1800, and 1900 were NOT leap years, NOR * will 2100 be a leap year),
* All years divisible by 4 but not by 100 ARE leap years (e.g., 2008, 2012, 2016),
* All years not divisible by 4 are NOT leap years (e.g. 2017, 2018, 2019).

## Process followed:
* Followed Test Driven Developemnt
* Used MVVM architectural pattern to seperate of development of the UI and business logic
* Used Android's LiveData to notify changes to Activity
* Added Test cases for all business logic
* Added Android Test cases to test the UI.
* Used Constraint Layout for designing UI

## Run
To run this project:

```
$ ./gradlew installDebug
```
To run tests:

```
$ ./gradlew build connectedCheck
```

To generate report of tests:

```
$ ./gradlew build jacocoTestReport assembleAndroidTest
```
## Code Coverage Report

## Output
![](https://github.com/2019-SOW-DEV-003/LeapYears/blob/master/screenshot.gif)
