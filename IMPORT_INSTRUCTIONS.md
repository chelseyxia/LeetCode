# Import to GitHub

This archive contains a repository-ready snapshot. The `main` branch is **not** modified automatically.

## Recommended: GitHub Desktop

1. Clone `chelseyxia/LeetCode` using GitHub Desktop.
2. Create or select the `setup/leetcode-auto-sync` branch (already created remotely). Fetch origin first.
3. Copy `solutions/`, `README.md`, `IMPORT_REPORT.json`, and `.gitignore` from this archive into the cloned repository folder.
4. Review changes in GitHub Desktop. Commit with message `Import historical Accepted Java solutions`.
5. Push branch to origin.
6. Open a pull request into `main` and review before merging.

The `IMPORT_INSTRUCTIONS.md` file is optional. Do not delete unrelated existing repository files during the import.

## Alternative: terminal

```bash
git clone https://github.com/chelseyxia/LeetCode.git
cd LeetCode
git fetch origin
git switch setup/leetcode-auto-sync || git switch -c setup/leetcode-auto-sync --track origin/setup/leetcode-auto-sync
# Copy the generated solutions/, README.md, IMPORT_REPORT.json, .gitignore into this folder.
git add solutions README.md IMPORT_REPORT.json .gitignore
git commit -m "Import historical Accepted Java solutions"
git push -u origin setup/leetcode-auto-sync
```
