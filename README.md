# moveit-client
Cordova client for moveit

## Install cordova
<code>npm install -g cordova</code>

## Install npm dependencies
<code> npm install </code>

## Building and run the app in your device
<code> cordova run android </code>

## Add Remote for Shared Client
We maintain a repo to share the ui code between mobile and web app for consistency

<code> `git remote add -f moveit-shared-client https://github.com/multunus/moveit-shared-client.git` </code>

### Pull changes to Client repo

<code> `git subtree pull --prefix www moveit-shared-client master --squash` </code>

# Updating the version
update version number in ```config.xml```
