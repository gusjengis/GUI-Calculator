git init -b main
git add .
git commit -m "initial commit"
gh repo create --source=. --public --push --remote origin
pause