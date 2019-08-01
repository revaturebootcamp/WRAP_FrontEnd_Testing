package com.revature.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=("features/WrapLogin.feature"), glue=("com.revature.glueCode"))
public class TestRunner 
{
}