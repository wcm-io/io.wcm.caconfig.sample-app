<img src="https://wcm.io/images/favicon-16@2x.png"/> Context-Aware Configuration AEM Sample Application
=============================================
[![Build](https://github.com/wcm-io/io.wcm.caconfig.editor/workflows/Build/badge.svg?branch=develop)](https://github.com/wcm-io/io.wcm.caconfig.editor/actions?query=workflow%3ABuild+branch%3Adevelop)


Deploy sample project
---------------------

You can use this scripts for a full deployment (application, sample content, configuration) into local AEM 6.5 or AEMaaCS instances.

Using the **AEM Page Persistence Strategy** from wcm.io Context-Aware Configuration Extensions:

* `build-deploy.sh` -> deploy to author on port 4502
* `build-deploy-publish.sh` -> deploy to publish on port 4503

Using the **default Persistence Strategy** from Sling Context-Aware Configuration:

* `build-deploy-defaultpersistence.sh` -> deploy to author on port 4502
* `build-deploy-defaultpersistence-publish.sh` -> deploy to publish on port 4503


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

* AEM 6.5.7+ or AEMaaCS SDK
* JDK 1.8 or Java 11
