<img src="https://wcm.io/images/favicon-16@2x.png"/> Context-Aware Configuration AEM Sample Application
=============================================
[![Build](https://github.com/wcm-io/io.wcm.caconfig.editor/workflows/Build/badge.svg?branch=develop)](https://github.com/wcm-io/io.wcm.caconfig.editor/actions?query=workflow%3ABuild+branch%3Adevelop)

This sample projects contains all wcm.io Context-Aware Configuration related modules with a bunch of sample code and sample content.

Deploy sample project
---------------------

You can use this scripts for a full deployment (application, sample content, configuration) into local AEM 6.5 or AEMaaCS instances.

By default, the **AEM Page Persistence Strategy** is used.

Deploy to local AEMaaCS SDK instance:

* `build-deploy.sh` -> deploy to author on port 4502
* `build-deploy-publish.sh` -> deploy to publish on port 4503

Deploy to local AEM 6.5 instance:

* `build-deploy_aem65.sh` -> deploy to author on port 45025
* `build-deploy-publish_aem65.sh` -> deploy to publish on port 45035

The deployment to AEM 6.5 also updates the Apache Sling Context-Aware Configuration modules to the latest versions - because of this the first deployment run may take some time to complete.


Open Configuration Editor
-------------------------

Open configuration editor at<br/>
[http://localhost:4502/content/contextaware-config-sample/en/config.html](http://localhost:4502/content/contextaware-config-sample/en/config.html)

To see how inheritance and override works you can also look at<br/>
[http://localhost:4502/content/contextaware-config-sample/en/sub-page/config.html](http://localhost:4502/content/contextaware-config-sample/en/sub-page/config.html)<br/>
[http://localhost:4502/content/contextaware-config-sample/en/sub-page/sub-page-override/config.html](http://localhost:4502/content/contextaware-config-sample/en/sub-page/sub-page-override/config.html)


Inspect Configuration
---------------------

You can look how the configuration is stored in the repository by browsing through `/conf/contextaware-config-sample`.


System requirements
-------------------

* AEM 6.5.17+ or AEMaaCS SDK
* Java 11
