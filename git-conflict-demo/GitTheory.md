# AI Notes

- notes
    
    # 📘 Git & GitHub — Source Code Management
    
    ---
    
    ## 🤔 Why Do We Need Git?
    
    Imagine this: you've been coding for weeks, your client's entire project lives only on your laptop — and then the system crashes. Everything is gone.
    
    Or another scenario: you're collaborating with a team, everyone is editing the same files on their own machines, and nobody knows whose version is "correct."
    
    This is exactly the problem **Source Code Management (SCM)** tools like Git solve.
    
    ### Core reasons to use Git:
    
    1. **Crash recovery** — If your system fails, pull your code back from the server and continue exactly where you left off.
    2. **Work from anywhere** — No need for pen drives or emailing files. Your code lives on a remote server you can access from any machine.
    3. **Team collaboration** — Multiple developers can work on the same codebase simultaneously, with a clear single source of truth.
    4. **Change tracking** — Every change is recorded: *who* made it, *what* they changed, and *when* — a full audit trail.
    
    ---
    
    ## 🧩 Git vs GitHub
    
    |  | Git | GitHub |
    | --- | --- | --- |
    | **What it is** | Version Control System (runs locally) | Remote server that hosts Git repositories |
    | **Where it lives** | Your machine (client-side) | The internet (server-side) |
    | **Role** | Tracks and manages changes to your code | Central hub where teams share and back up code |
    
    > **Git** is the tool. **GitHub** is one place to store what Git manages.
    > 
    
    Other popular remote repository platforms: **Bitbucket**, **GitLab**, **AWS CodeCommit**, **Azure Repos**.
    
    ---
    
    ## ⚙️ How Git Works — The Three Zones
    
    When you run `git init` in a folder, Git divides your project into **3 logical areas**:
    
    ```
    ┌─────────────────────────────────────────────────────────────┐
    │                    Your Project Folder                      │
    │                                                             │
    │  ┌───────────────┐   git add   ┌──────────────┐            │
    │  │   Working     │ ──────────► │   Staging    │            │
    │  │   Directory   │             │   Area       │            │
    │  │               │             │              │            │
    │  │ (files you're │             │ (files ready │            │
    │  │  editing now) │             │  to commit)  │            │
    │  └───────────────┘             └──────┬───────┘            │
    │                                       │ git commit         │
    │                                       ▼                    │
    │                               ┌──────────────┐            │
    │                               │    Local     │            │
    │                               │  Repository  │            │
    │                               │  (.git/)     │            │
    │                               └──────┬───────┘            │
    └──────────────────────────────────────┼─────────────────────┘
                                           │ git push
                                           ▼
                                  ┌─────────────────┐
                                  │     GitHub      │
                                  │ (Remote Repo)   │
                                  └─────────────────┘
    ```
    
    | Zone | Description |
    | --- | --- |
    | **Working Directory** | Where you actively write and edit your code |
    | **Staging Area** | A preparation zone — you choose which changes to include in the next save |
    | **Local Repository** | Your personal history of committed changes, stored in the hidden `.git/` folder |
    | **Remote Repository** | GitHub (or equivalent) — the shared, backed-up version of your code |
    
    > The `.git/` folder is created by `git init` and stores everything — history, who changed what, timestamps, branches, and more. **Never delete it.**
    > 
    
    ---
    
    ## 🔁 The Git Workflow
    
    Code moves through the zones in one direction when saving, and back when retrieving:
    
    ### Saving your work (local → remote):
    
    ```bash
    # 1. Stage your changes
    git add filename.java        # stage a specific file
    git add .                    # stage all changed files
    
    # 2. Commit to local repository (with a message describing what you did)
    git commit -m "Add login feature"
    
    # 3. Push to remote repository (GitHub)
    git push origin main
    ```
    
    ### Retrieving code (remote → local):
    
    ```bash
    # Download changes from remote into your local repo + branch
    git pull origin main
    
    # Switch to a branch (move changes into your working directory)
    git checkout branch-name
    
    # Merge a branch into your current branch
    git merge branch-name
    ```
    
    ---
    
    ## 📖 Essential Commands Reference
    
    ### Setup & Initialization
    
    ```bash
    git init                        # Initialize a new Git repo in current folder
    git clone <url>                 # Copy a remote repo to your local machine
    git config --global user.name "Your Name"
    git config --global user.email "you@example.com"
    ```
    
    ### Staging & Committing
    
    ```bash
    git status                      # See what's changed / staged / untracked
    git add <file>                  # Stage a specific file
    git add .                       # Stage all changes
    git commit -m "message"         # Save staged changes to local repo
    git log                         # View commit history
    git log --oneline               # Compact commit history
    ```
    
    ### Remote Repository
    
    ```bash
    git remote add origin <url>     # Link your local repo to a remote (GitHub)
    git push origin main            # Push commits to remote
    git pull origin main            # Fetch + merge remote changes locally
    git fetch                       # Fetch remote changes WITHOUT merging
    ```
    
    ### Branching
    
    ```bash
    git branch                      # List all branches
    git branch feature-login        # Create a new branch
    git checkout feature-login      # Switch to a branch
    git checkout -b feature-login   # Create AND switch in one step
    git merge feature-login         # Merge a branch into current branch
    git branch -d feature-login     # Delete a branch (after merging)
    ```
    
    ### Undoing Changes
    
    ```bash
    git restore <file>              # Discard changes in working directory
    git reset HEAD <file>           # Unstage a file (keep changes)
    git revert <commit-hash>        # Undo a commit safely (creates a new commit)
    ```
    
    ---
    
    ## 🌿 Branching — Why It Matters
    
    A **branch** is an isolated copy of the codebase where you can work freely without affecting the main code. This is essential for teams.
    
    ```
    main  ──●──────────────────────────●── (stable, production-ready)
             \\                        /
              ●──●──●  feature-login  (your work, safely isolated)
    ```
    
    **Typical workflow:**
    
    1. Create a branch for your feature/bugfix
    2. Work and commit on that branch
    3. When done, merge it back into `main`
    4. Delete the feature branch
    
    This ensures `main` always stays clean and deployable.
    
    ---
    
    ## 🗺️ Summary
    
    ```
    git init        →  Set up a new repo (creates .git/)
    git add         →  Working Directory  →  Staging Area
    git commit      →  Staging Area       →  Local Repository
    git push        →  Local Repository   →  Remote (GitHub)
    git pull        →  Remote (GitHub)    →  Local Repository
    git checkout    →  Switch branches / restore working directory
    git merge       →  Combine branch changes into current branch
    git status      →  See the current state of your working directory
    git log         →  View the full commit history
    ```
    
    ---
    
    > **Best Practice:** Commit often, write meaningful commit messages, and push regularly. Treat your remote repo as your safety net — always keep it up to date.
    > 

### Git

→ Source Code Management tool(SCM) & Version Control System (VCS)

 

- Problems
    - if client system has all program code… and wants to be deployed on server but before completion client code is messed up and all is lost..!!
    - thus we need a backup of the code, so if system crashes source code is not lost
    - Thus Good practice → push code to a server that will hold and track the source code for changes (Date of pushing code to server).

- **Need for Git/ Source Code Management Tools**
    1. Whenever crash,pull code back and continue
    2. If system is not crashed but u dont have current device, but source code is on another. So pull and continue instead of keeping pen drives and all
    3. Team Scenes, all ppl have their own system code and we wanna manage and monitor the entire source code so then all ppl should have a consistent code and push data and stuff.
    4. We should also track who has done what changes to the code. And what time the change was done.

## Git → client side [most widely used]

- Github → server side[Remote Repository]
- Github is the remote central server repository for any client to connect to and push data.
- Other exs→ BitBucker, AWS,AZURE etc.

- GIT working implementation
    
    .git holds all info done on that folder..who did what ,track changes etc
    
    - git init → divides current folder/directory into 3 parts
    1. Working Directory → place where ur currently working
    2. Staging Area → 
    3. Local Repository → 
    
    So we need to pass code from working directory to staging area, from there to local repository and from there to remote repository. Then only itll be available in GITHUB.
    

- git add [files] sends files from working directory to staging area.
- now to put file from stage to local repository we commit the change
- to push from local repo to remote repo we need to push the data

![image.png](attachment:97044532-2568-4dde-8ba8-fd346bfb0376:image.png)

while pull it enters ur branch, but we need to `git checkout` to ensure we go from local repo to working directory or even `git merge`  to get to wd and resume.

![image.png](attachment:0f28c0fd-9f92-4db3-8619-f86659e3ebd5:image.png)

# Commands and Terminology

| Command | What it does |
| --- | --- |
| git init | initialize project as git project |
| git status | to see status if repo or not..checks  →.git folder |
| git add [files] | send files from working directory to staging area |
| git commit -m “msg” | send files from stage to local repo |
| git config —global [user.email](http://user.email) “”
git config —global [user.name](http://user.name) “” | credentials for repository |
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
| git tag -l “v*.0” | show all tags ending in .0 |
|  |  |

| Entity | What it does |
| --- | --- |
| Branches | present in remote repository,
branches are for different tasks/people/features
main/masrter/(custom-name)
 |
| commit | push to local repo, each commit has a SHA encrypted unique identifiier |
| Tagging | when we push data,we wanna give versioning. Tagging allocates version numbers(tag) |

# Assignment

- demonstrate merge conflict and how to resolve it.

- Solution
    
    # 🌿 STEP 2 — Create Feature Branch
    
    ```powershell
    git checkout-b feature-update
    ```
    
    Now you're in `feature-update` branch.
    
    ---
    
    # ✏️ STEP 3 — Modify GitTheory.md (Feature Branch)
    
    Open:
    
    ```
    git-conflict-demo/GitTheory.md
    ```
    
    Go to the **first heading line** (or any specific line near top).
    
    For example if it says:
    
    ```
    # Git Theory
    ```
    
    Change it to:
    
    ```
    # Git Theory - Updated from Feature Branch
    ```
    
    Save the file.
    
    Now commit:
    
    ```powershell
    git add .
    git commit-m"Feature branch updated heading"
    ```
    
    ---
    
    # 🔁 STEP 4 — Switch Back to Main
    
    ```powershell
    git checkout master
    ```
    
    (If your branch is named `main`, use `main` instead.)
    
    ---
    
    # ✏️ STEP 5 — Modify SAME Line Differently
    
    Open the same file:
    
    ```
    git-conflict-demo/GitTheory.md
    ```
    
    Change that SAME heading to:
    
    ```
    # Git Theory - UpdatedfromMain Branch
    ```
    
    Save it.
    
    Now commit:
    
    ```powershell
    git add .
    git commit-m"Main branch updated heading"
    ```
    
    ---
    
    # 💥 STEP 6 — Merge and Create Conflict
    
    Now run:
    
    ```powershell
    git merge feature-update
    ```
    
    You should see:
    
    ```
    Auto-merging git-conflict-demo/GitTheory.mdCONFLICT (content): Mergeconflictin git-conflict-demo/GitTheory.md
    Automatic merge failed; fix conflictsandthencommit the result.
    ```
    
    🔥 BOOM — Conflict created.
    
    ---
    
    # 🔎 STEP 7 — Show Conflict Markers (Important for Assignment)
    
    Open the file.
    
    You will see something like:
    
    ```
    <<<<<<< HEAD# Git Theory - Updated from Main Branch
    =======# Git Theory - Updated from Feature Branch
    >>>>>>> feature-update
    ```
    
    Explain in assignment:
    
    - `<<<<<<< HEAD` → current branch (main/master)
    - `=======` → separator
    - `>>>>>>> feature-update` → incoming branch
    
    Git cannot decide which change to keep.
    
    ---
    
    # ✅ STEP 8 — Resolve Conflict
    
    Decide final version. For example:
    
    ```
    # Git Theory - Updated from Both Branches
    ```
    
    Delete ALL conflict markers:
    
    ```
    <<<<<<<
    =======
    >>>>>>>
    ```
    
    Save the file.
    
    Now finalize:
    
    ```powershell
    git add .
    git commit-m"Resolved merge conflict in GitTheory.md"
    ```
    
    ---
    
    # 🎉 DONE
    
    Now run:
    
    ```powershell
    git log--oneline--graph--all
    ```
    
    You’ll see merge history — looks impressive in demo.
    
    ---
    
    # 🧠 How to Explain in Viva
    
    If sir asks:
    
    👉 What is a merge conflict?
    
    Answer:
    
    > A merge conflict occurs when two branches modify the same line of a file differently and Git cannot automatically merge them. The developer must manually resolve the conflict and commit the corrected version.
    >
