$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bdd/groups.feature");
formatter.feature({
  "name": "Groups",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Group creation",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "name": "I create a new group with name \u003cname\u003e, header \u003cheader\u003e and footer \u003cfooter\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the new set of groups is equal to the old set with added group",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "header",
        "footer"
      ]
    },
    {
      "cells": [
        "test name",
        "test header",
        "test footer"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Group creation",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.match({
  "location": "GroupStepDefinitions.loadGroups()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I create a new group with name test name, header test header and footer test footer",
  "keyword": "When "
});
formatter.match({
  "location": "GroupStepDefinitions.createGroup(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new set of groups is equal to the old set with added group",
  "keyword": "Then "
});
formatter.match({
  "location": "GroupStepDefinitions.verifyGroupCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});