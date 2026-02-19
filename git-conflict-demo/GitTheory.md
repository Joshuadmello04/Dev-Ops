<!-- # Git Theory - Updated from Master Branch
# Git Theory - Updated from Feature Branch -->

# Git Theory - Updated from Both Branches

\# AI Notes



\- notes

&nbsp;   

&nbsp;   # 📘 Git \& GitHub — Source Code Management

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 🤔 Why Do We Need Git?

&nbsp;   

&nbsp;   Imagine this: you've been coding for weeks, your client's entire project lives only on your laptop — and then the system crashes. Everything is gone.

&nbsp;   

&nbsp;   Or another scenario: you're collaborating with a team, everyone is editing the same files on their own machines, and nobody knows whose version is "correct."

&nbsp;   

&nbsp;   This is exactly the problem \*\*Source Code Management (SCM)\*\* tools like Git solve.

&nbsp;   

&nbsp;   ### Core reasons to use Git:

&nbsp;   

&nbsp;   1. \*\*Crash recovery\*\* — If your system fails, pull your code back from the server and continue exactly where you left off.

&nbsp;   2. \*\*Work from anywhere\*\* — No need for pen drives or emailing files. Your code lives on a remote server you can access from any machine.

&nbsp;   3. \*\*Team collaboration\*\* — Multiple developers can work on the same codebase simultaneously, with a clear single source of truth.

&nbsp;   4. \*\*Change tracking\*\* — Every change is recorded: \*who\* made it, \*what\* they changed, and \*when\* — a full audit trail.

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 🧩 Git vs GitHub

&nbsp;   

&nbsp;   |  | Git | GitHub |

&nbsp;   | --- | --- | --- |

&nbsp;   | \*\*What it is\*\* | Version Control System (runs locally) | Remote server that hosts Git repositories |

&nbsp;   | \*\*Where it lives\*\* | Your machine (client-side) | The internet (server-side) |

&nbsp;   | \*\*Role\*\* | Tracks and manages changes to your code | Central hub where teams share and back up code |

&nbsp;   

&nbsp;   > \*\*Git\*\* is the tool. \*\*GitHub\*\* is one place to store what Git manages.

&nbsp;   > 

&nbsp;   

&nbsp;   Other popular remote repository platforms: \*\*Bitbucket\*\*, \*\*GitLab\*\*, \*\*AWS CodeCommit\*\*, \*\*Azure Repos\*\*.

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## ⚙️ How Git Works — The Three Zones

&nbsp;   

&nbsp;   When you run `git init` in a folder, Git divides your project into \*\*3 logical areas\*\*:

&nbsp;   

&nbsp;   ```

&nbsp;   ┌─────────────────────────────────────────────────────────────┐

&nbsp;   │                    Your Project Folder                      │

&nbsp;   │                                                             │

&nbsp;   │  ┌───────────────┐   git add   ┌──────────────┐            │

&nbsp;   │  │   Working     │ ──────────► │   Staging    │            │

&nbsp;   │  │   Directory   │             │   Area       │            │

&nbsp;   │  │               │             │              │            │

&nbsp;   │  │ (files you're │             │ (files ready │            │

&nbsp;   │  │  editing now) │             │  to commit)  │            │

&nbsp;   │  └───────────────┘             └──────┬───────┘            │

&nbsp;   │                                       │ git commit         │

&nbsp;   │                                       ▼                    │

&nbsp;   │                               ┌──────────────┐            │

&nbsp;   │                               │    Local     │            │

&nbsp;   │                               │  Repository  │            │

&nbsp;   │                               │  (.git/)     │            │

&nbsp;   │                               └──────┬───────┘            │

&nbsp;   └──────────────────────────────────────┼─────────────────────┘

&nbsp;                                          │ git push

&nbsp;                                          ▼

&nbsp;                                 ┌─────────────────┐

&nbsp;                                 │     GitHub      │

&nbsp;                                 │ (Remote Repo)   │

&nbsp;                                 └─────────────────┘

&nbsp;   ```

&nbsp;   

&nbsp;   | Zone | Description |

&nbsp;   | --- | --- |

&nbsp;   | \*\*Working Directory\*\* | Where you actively write and edit your code |

&nbsp;   | \*\*Staging Area\*\* | A preparation zone — you choose which changes to include in the next save |

&nbsp;   | \*\*Local Repository\*\* | Your personal history of committed changes, stored in the hidden `.git/` folder |

&nbsp;   | \*\*Remote Repository\*\* | GitHub (or equivalent) — the shared, backed-up version of your code |

&nbsp;   

&nbsp;   > The `.git/` folder is created by `git init` and stores everything — history, who changed what, timestamps, branches, and more. \*\*Never delete it.\*\*

&nbsp;   > 

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 🔁 The Git Workflow

&nbsp;   

&nbsp;   Code moves through the zones in one direction when saving, and back when retrieving:

&nbsp;   

&nbsp;   ### Saving your work (local → remote):

&nbsp;   

&nbsp;   ```bash

&nbsp;   # 1. Stage your changes

&nbsp;   git add filename.java        # stage a specific file

&nbsp;   git add .                    # stage all changed files

&nbsp;   

&nbsp;   # 2. Commit to local repository (with a message describing what you did)

&nbsp;   git commit -m "Add login feature"

&nbsp;   

&nbsp;   # 3. Push to remote repository (GitHub)

&nbsp;   git push origin main

&nbsp;   ```

&nbsp;   

&nbsp;   ### Retrieving code (remote → local):

&nbsp;   

&nbsp;   ```bash

&nbsp;   # Download changes from remote into your local repo + branch

&nbsp;   git pull origin main

&nbsp;   

&nbsp;   # Switch to a branch (move changes into your working directory)

&nbsp;   git checkout branch-name

&nbsp;   

&nbsp;   # Merge a branch into your current branch

&nbsp;   git merge branch-name

&nbsp;   ```

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 📖 Essential Commands Reference

&nbsp;   

&nbsp;   ### Setup \& Initialization

&nbsp;   

&nbsp;   ```bash

&nbsp;   git init                        # Initialize a new Git repo in current folder

&nbsp;   git clone <url>                 # Copy a remote repo to your local machine

&nbsp;   git config --global user.name "Your Name"

&nbsp;   git config --global user.email "you@example.com"

&nbsp;   ```

&nbsp;   

&nbsp;   ### Staging \& Committing

&nbsp;   

&nbsp;   ```bash

&nbsp;   git status                      # See what's changed / staged / untracked

&nbsp;   git add <file>                  # Stage a specific file

&nbsp;   git add .                       # Stage all changes

&nbsp;   git commit -m "message"         # Save staged changes to local repo

&nbsp;   git log                         # View commit history

&nbsp;   git log --oneline               # Compact commit history

&nbsp;   ```

&nbsp;   

&nbsp;   ### Remote Repository

&nbsp;   

&nbsp;   ```bash

&nbsp;   git remote add origin <url>     # Link your local repo to a remote (GitHub)

&nbsp;   git push origin main            # Push commits to remote

&nbsp;   git pull origin main            # Fetch + merge remote changes locally

&nbsp;   git fetch                       # Fetch remote changes WITHOUT merging

&nbsp;   ```

&nbsp;   

&nbsp;   ### Branching

&nbsp;   

&nbsp;   ```bash

&nbsp;   git branch                      # List all branches

&nbsp;   git branch feature-login        # Create a new branch

&nbsp;   git checkout feature-login      # Switch to a branch

&nbsp;   git checkout -b feature-login   # Create AND switch in one step

&nbsp;   git merge feature-login         # Merge a branch into current branch

&nbsp;   git branch -d feature-login     # Delete a branch (after merging)

&nbsp;   ```

&nbsp;   

&nbsp;   ### Undoing Changes

&nbsp;   

&nbsp;   ```bash

&nbsp;   git restore <file>              # Discard changes in working directory

&nbsp;   git reset HEAD <file>           # Unstage a file (keep changes)

&nbsp;   git revert <commit-hash>        # Undo a commit safely (creates a new commit)

&nbsp;   ```

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 🌿 Branching — Why It Matters

&nbsp;   

&nbsp;   A \*\*branch\*\* is an isolated copy of the codebase where you can work freely without affecting the main code. This is essential for teams.

&nbsp;   

&nbsp;   ```

&nbsp;   main  ──●──────────────────────────●── (stable, production-ready)

&nbsp;            \\\\                        /

&nbsp;             ●──●──●  feature-login  (your work, safely isolated)

&nbsp;   ```

&nbsp;   

&nbsp;   \*\*Typical workflow:\*\*

&nbsp;   

&nbsp;   1. Create a branch for your feature/bugfix

&nbsp;   2. Work and commit on that branch

&nbsp;   3. When done, merge it back into `main`

&nbsp;   4. Delete the feature branch

&nbsp;   

&nbsp;   This ensures `main` always stays clean and deployable.

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   ## 🗺️ Summary

&nbsp;   

&nbsp;   ```

&nbsp;   git init        →  Set up a new repo (creates .git/)

&nbsp;   git add         →  Working Directory  →  Staging Area

&nbsp;   git commit      →  Staging Area       →  Local Repository

&nbsp;   git push        →  Local Repository   →  Remote (GitHub)

&nbsp;   git pull        →  Remote (GitHub)    →  Local Repository

&nbsp;   git checkout    →  Switch branches / restore working directory

&nbsp;   git merge       →  Combine branch changes into current branch

&nbsp;   git status      →  See the current state of your working directory

&nbsp;   git log         →  View the full commit history

&nbsp;   ```

&nbsp;   

&nbsp;   ---

&nbsp;   

&nbsp;   > \*\*Best Practice:\*\* Commit often, write meaningful commit messages, and push regularly. Treat your remote repo as your safety net — always keep it up to date.

&nbsp;   > 



\### Git



→ Source Code Management tool(SCM) \& Version Control System (VCS)



&nbsp;



\- Problems

&nbsp;   - if client system has all program code… and wants to be deployed on server but before completion client code is messed up and all is lost..!!

&nbsp;   - thus we need a backup of the code, so if system crashes source code is not lost

&nbsp;   - Thus Good practice → push code to a server that will hold and track the source code for changes (Date of pushing code to server).



\- \*\*Need for Git/ Source Code Management Tools\*\*

&nbsp;   1. Whenever crash,pull code back and continue

&nbsp;   2. If system is not crashed but u dont have current device, but source code is on another. So pull and continue instead of keeping pen drives and all

&nbsp;   3. Team Scenes, all ppl have their own system code and we wanna manage and monitor the entire source code so then all ppl should have a consistent code and push data and stuff.

&nbsp;   4. We should also track who has done what changes to the code. And what time the change was done.



\## Git → client side \[most widely used]



\- Github → server side\[Remote Repository]

\- Github is the remote central server repository for any client to connect to and push data.

\- Other exs→ BitBucker, AWS,AZURE etc.



\- GIT working implementation

&nbsp;   

&nbsp;   .git holds all info done on that folder..who did what ,track changes etc

&nbsp;   

&nbsp;   - git init → divides current folder/directory into 3 parts

&nbsp;   1. Working Directory → place where ur currently working

&nbsp;   2. Staging Area → 

&nbsp;   3. Local Repository → 

&nbsp;   

&nbsp;   So we need to pass code from working directory to staging area, from there to local repository and from there to remote repository. Then only itll be available in GITHUB.

&nbsp;   



\- git add \[files] sends files from working directory to staging area.

\- now to put file from stage to local repository we commit the change

\- to push from local repo to remote repo we need to push the data



!\[image.png](attachment:97044532-2568-4dde-8ba8-fd346bfb0376:image.png)



while pull it enters ur branch, but we need to `git checkout` to ensure we go from local repo to working directory or even `git merge`  to get to wd and resume.



!\[image.png](attachment:0f28c0fd-9f92-4db3-8619-f86659e3ebd5:image.png)



\# Commands and Terminology



| Command | What it does |

| --- | --- |

| git init | initialize project as git project |

| git status | to see status if repo or not..checks  →.git folder |

| git add \[files] | send files from working directory to staging area |

| git commit -m “msg” | send files from stage to local repo |

| git config —global \[user.email](http://user.email) “”

git config —global \[user.name](http://user.name) “” | credentials for repository |

| git remote add origin …url/path…. | to connect to a created repository ie point to it |

| git branch -M (branch) | to set active branch |

| git push -u origin (branch) | to send from local repo to remote repo |

| git restore <file> | to discard changes in working directory |

| git pull  | to pull code/latest tracked version |

| git log | to show log files/ logs of all commits + time + person |

| git branch <name>  | to create a new branch, when u create a new one, all master repo content will be available in this new branch too |

| git checkout <name> | to switch to another branch |

| git merge <other branch> | merges that content from branch to the branch currently being pointed to |

| git branch -d <name> 

or

git branch —delete <name> | so now one branch isnt needed anymore then to delete it. |

| git push origin -d <name> | to delete from remote repo…when whole branch purpose is over in a push |

| git tag <version number1.0>

ex git tag v1.0 | for tagging ie to set the tag |

| git tag  | specifies version→ pts to last command |

| git show <version> | to show tags and merges and author |

| git tag -l “v\*.0” | show all tags ending in .0 |

|  |  |



| Entity | What it does |

| --- | --- |

| Branches | present in remote repository,

branches are for different tasks/people/features

main/masrter/(custom-name)

&nbsp;|

| commit | push to local repo, each commit has a SHA encrypted unique identifiier |

| Tagging | when we push data,we wanna give versioning. Tagging allocates version numbers(tag) |



\# Assignment



\- demonstrate merge conflict and how to resolve it.

