
# example:
#   > make deploy version=1.0.1-RC2 projectId=solar-bpm
deploy:
	@[ "${version}" ] && echo "Setting version to ${version}" && mvn org.codehaus.mojo:versions-maven-plugin:2.4:set -DnewVersion="${version}" || ( echo "VERSION NOT SET ${version}"; )
	@[ "${projectId}" ] && echo "Init deploy to project ${projectId}" && mvn clean package appengine:deploy -Dapp.deploy.projectId=${projectId} || ( echo "PROJECTID NOT SET ${projectId}"; )

build:
	mvn clean package