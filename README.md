# Jetty Cobertura Coverage Service plugin

This Project provides a shutdown hook that saves Cobertura coverage data on server "stop".

## Rationale ##

By default Cobertura saves its coverage data on VM exit, i.e. on Maven VM exit. Due to this shortcoming other plugins using coverage data during later Maven phases detect that coverage is set to 0%. 

This project ensures that coverage data is saved right when Jetty Server is stoped, which in turn allows other plugins such as [``qualinsight-mojo-cobertura``](https://github.com/QualInsight/qualinsight-mojo-cobertura) to use correctly generated coverage data. 

## Supported Jetty versions

* Jetty 9.3.3.v20150827
* Jetty 9.2.13.v20150730
* Jetty 8.1.17.v20150415
* Jetty 7.6.17.v20150415

## Usage example

A full usage example is provided on the [``qualinsight-mojo-cobertura-example``](https://github.com/pawlakm/qualinsight-mojo-cobertura-example) project's page.

## Build status

[![Build Status](https://travis-ci.org/QualInsight/qualinsight-plugins-jetty.svg)](https://travis-ci.org/QualInsight/qualinsight-plugins-jetty)