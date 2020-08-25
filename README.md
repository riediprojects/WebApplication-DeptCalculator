# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 17-548-371

Project idea short description: 
Mit dieser Webapplikation sollen finanzielle Ausgaben, welche in einem Haushalts zwischen Bewohnern anfallen, fair verwaltet werden können. 
Die Umsetzung sieht vor, dass die Mitbewohner ihre Einkäufe, bezahlte Rechnungen oder sonstige Ausgaben, welche die Gemeinschaft betreffen mittels einer Eingabemaske erfassen können. Weitere zentrale Bestandteile sollen sein: 
- Eine Tabelle, die alle erfassten Einträge übersichtlich aufliste. 
- Die Information als Zahlen oder Statistik, wer, bei wem, wie viele Schulden hat. 

## Project confirmation

I am looking forward for your implementation! You might start.

## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Hand-written, static HTML 
project description:      (if other than `index.html` in project root directory)

External contributions:

Other comments: 

I'm particular proud of:


## Project grading 

[index.html](index.html) looks nice, is valid and makes use of _semantic_ elements.

Application starts and looks nice. I've noticed the default server port change... :smirk:
Things which could be improved:

* A given creditor should NOT be able to make new entry for other creditor than himself.
* As creditor, I should be able to edit/remove my own entries.
* If I do NOT have sufficient rights, I should even see the **delete** button. On view side,
**Grails** is offering some support via taglibs for such task.

#### Features

* Navigation, constraints on domain model(s)
* Spring Security with styled login
* 4 domain models (whose 3 are security related and NOT really new...)

#### Engineering

* 4 unit tests
* A quite impressive commit log

I am giving you 1 point for the use of semantic elements and 2 points for design.

You did a really good job. You've showed a good command of web engineer principles and you 
took full advantage of **Grails** features to materialize your project. Congratulations!

Grade: **6.0**

---
**QUESTION**

You've started a **taglib** `grails-app/taglib/MyMoneyTagLib.groovy`. But it is NOT used, right?

---# WEBEC
