#!/bin/bash

git fetch origin develop:develop

function merge() {
  git checkout $2
  git pull --rebase origin $2
  git merge --no-ff -m "Merge branch '$1' into $2" $1
  git push origin $2
}

merge master develop
