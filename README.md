# Plugins for Jetty 

This Project provides "plugins" for the Jetty Server.

[![Build Status](https://travis-ci.org/QualInsight/qualinsight-plugins-jetty.svg)](https://travis-ci.org/QualInsight/qualinsight-plugins-jetty)

## Available plugins

### Cobertura shutdown hook 

By default Cobertura saves its coverage data on VM exit, i.e. on Maven VM exit. Due to this shortcoming other plugins using coverage data during later Maven phases detect that coverage is set to 0%. 

This plugin ensures that coverage data is saved right when Jetty Server is stopped, which in turn allows other tools such as [``qualinsight-mojo-cobertura``](https://github.com/QualInsight/qualinsight-mojo-cobertura) to use correctly generated coverage data. 

#### Usage

A full usage example of the cobertura shutdown hook is provided on the [``qualinsight-mojo-cobertura-example``](https://github.com/QualInsight/qualinsight-mojo-cobertura-example) project's page.

## Supported Jetty versions

* Jetty 9.3.3.v20150827
* Jetty 9.2.13.v20150730
* Jetty 8.1.17.v20150415
* Jetty 7.6.17.v20150415


## Contributing to the project

If you want to contribute to this project, please have a look at the [developer toolset page](https://github.com/QualInsight/qualinsight-developer-toolset). It provides contribution guidelines I ask you to follow. Thanks in advance for your help !
