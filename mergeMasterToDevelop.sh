#!bin/bash

git fetch develop:develop

function merge() {
  git checkout $2
  git pull --rebase origin $2
  git pull --no-ff -m "Merge branch '$1' into $2" $1
  git push origin $2
}

merge master develop
