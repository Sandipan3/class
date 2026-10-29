# Compiler Lab — 50 beginner solutions

Each question is in its own file. File names use short camelCase names:
- `q01Open.c`–`q25ReverseFile.c`: C file-handling programs
- `q26Number.l`–`q50Directive.l`: Flex/Lex programs

## 1. Install tools

### Windows (recommended: MSYS2 UCRT64)
1. Install MSYS2 from https://www.msys2.org/
2. Open **MSYS2 UCRT64** from the Start menu.
3. Run:
   ```bash
   pacman -Syu
   ```
   If it asks you to close the terminal, reopen **MSYS2 UCRT64** and run the update command again.
4. Install GCC and Flex:
   ```bash
   pacman -S --needed mingw-w64-ucrt-x86_64-gcc flex
   ```
5. Use the MSYS2 UCRT64 terminal for the commands below. Move/copy this folder somewhere accessible, or `cd` to its path (MSYS2 paths look like `/c/Users/YourName/...`).

### Linux (Debian/Ubuntu/WSL)
```bash
sudo apt update
sudo apt install build-essential flex
```

Check that the tools are installed:
```bash
gcc --version
flex --version
```

## 2. Run a C program (questions 1–25)

Open a terminal in this folder. Compile one file at a time. For example:
```bash
gcc q01Open.c -o q01Open
./q01Open
```
In MSYS2 UCRT64, `./q01Open.exe` also works. On Windows PowerShell with GCC already on PATH, run `.\q01Open.exe`.

Do not compile all C files into one executable: each file has its own `main()`.

### Input files used by the C programs
Create these text files in the same folder before running the relevant programs:
- `input.txt`: used by questions 1, 2, 3, 6–11, 14–16, 20, 24, 25.
- `numbers.txt`: used by questions 12 and 17. Put integers separated by spaces or newlines, e.g. `12 -4 8 20`.
- `input2.txt`: used by question 19, alongside `input.txt`.

Quick setup example in the terminal:
```bash
printf "Hello compiler lab\nThis is a test 123\n" > input.txt
printf "12 -4 8 20\n" > numbers.txt
printf "Second file\n" > input2.txt
```
Question 1 only reports success if `input.txt` exists. Questions 4, 5, 13, 18 and 23 create output files themselves. Questions 21 and 22 ask for filenames; use test files because these programs delete or rename files.

### Run any other C question
Replace the filename and output name with the question you want:
```bash
gcc q07CountChar.c -o q07CountChar
./q07CountChar
```

## 3. Run a Lex/Flex program (questions 26–50)

Use Flex to generate C code, then compile it:
```bash
flex q26Number.l
gcc lex.yy.c -o q26Number
./q26Number
```
Replace `q26Number.l` and `q26Number` with the desired file and matching short name. For example, question 42:
```bash
flex q42Arithmetic.l
gcc lex.yy.c -o q42Arithmetic
./q42Arithmetic
```
Each `.l` file is a separate program. Run `flex` again for every question because it overwrites `lex.yy.c`.

Type your input, then send EOF:
- Linux/WSL/MSYS2 terminal: **Ctrl+D**
- Windows console: **Ctrl+Z**, then **Enter**

For question 37 (Armstrong number), link the math library on Linux:
```bash
flex q37Armstrong.l
gcc lex.yy.c -o q37Armstrong -lm
./q37Armstrong
```
On MSYS2, `-lm` is usually accepted too.

## 4. Example Lex run
```bash
flex q29ToUpper.l
gcc lex.yy.c -o q29ToUpper
./q29ToUpper
```
Type `hello world`, press Enter, then Ctrl+D. Output should include `HELLO WORLD`.

## Notes
- Run only one program at a time.
- File-based C programs look for their input files in the **current working directory**, so run them from this folder.
- The email and identifier patterns are practical beginner examples, not complete formal validators for every possible edge case.
- Question 35 removes `//` comments from input text; as a simple lab exercise it does not parse C strings, so `//` inside a string literal will also be removed.
- Question 47 collapses each run of spaces/tabs to one space; it does not trim leading/trailing whitespace.
