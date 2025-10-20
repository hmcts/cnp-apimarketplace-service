
# With project details of
apim:                                                   # product name in Jenkinsfile_CNP
team: "API Marketplace"                                 # team 'display name'
namespace: apim                                         # Kubernetes namespace
slack:
  contact_channel: #api-marketplace-tech                # public channel that you can be contacted at
  build_notices_channel: #api-marketplace-build-notices # all build notices will be sent here
tags:
  application: "api-marketplace-service"          # name that your service is known to by FinOps


# Add jenkins topic to project
i.e. jenkins-cft-a-c


# Add project to jenkins
https://github.com/hmcts/cnp-jenkins-config.git
team-config.yml
```
apim:
  team: "API Marketplace"
  azure_ad_group: dcd_apim
  namespace: "apim"
  slack:
    contact_channel: "#api-marketplace-tech"
    channel_id: "C09K1JUSYVA"
    build_notices_channel: "#api-marketplace-build-notices"
  tags:
    application: api-marketplace-service
```

https://hmcts.github.io/ways-of-working/new-component/github-repo.html#create-a-github-repository
