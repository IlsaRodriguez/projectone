//*CLASS: class name (main.java)
//* DESCRIPTION
//* A description of the contents of this //file.
//*
//* COURSE AND PROJECT INFORMATION
//* CSE205 Object Oriented Programming and Data Structures, session B 2022
//* Project Number: 1
//*
//* AUTHOR: Ilsa Ramirez     
//* email: iramirez@asu.edu 


import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

public static void main(String[] args) throws FileNotFoundException {
Main mainObject = new Main();
mainObject.run();
}

private void run() throws FileNotFoundException {
ArrayList<Integer> list = list();
ArrayList<Integer> runups = runups(list);
ArrayList<Integer> rundowns = rundowns(list);
ArrayList<Integer> merger = merger(runups, rundowns);
int t = total(merger);
output(t, merger);
}

public ArrayList<Integer> runups(ArrayList<Integer> list) {
ArrayList<Integer> runs = new ArrayList<Integer>();
int k = 0;
int a = list.get(0);

for (int i = 0; i < list.size(); i++) {
if (k >= runs.size()) {
runs.add(0);
}
if (i <= list.size()) {
int b = list.get(i);
if (a >= b) {
int e = runs.get(k);
e++;
runs.set(k, e);
k = 0;
} else {
k++;
if (k >= runs.size()) {
runs.add(0);
}
if (i >= list.size() - 1) {
int e = runs.get(k);
e++;
runs.set(k, e);
}
}
a = b;
}
} //End for loop
return runs;
}

public ArrayList<Integer> rundowns(ArrayList<Integer> list) {
ArrayList<Integer> runs = new ArrayList<Integer>();
int k = 0;
int a = list.get(0);

for (int i = 0; i < list.size(); i++) {
if (k >= runs.size()) {
runs.add(0);
}
if (i <= list.size()) {
int b = list.get(i);
if (a <= b) {
int e = runs.get(k);
e++;
runs.set(k, e);
k = 0;
} else {
k++;
if (k >= runs.size()) {
runs.add(0);
}
if (i == list.size() - 1) {
int e = runs.get(k);
e++;
runs.set(k, e);
}
}
a = b;
}
} //End for loop,
return runs;
}

public ArrayList<Integer> merger(ArrayList<Integer> ups, ArrayList<Integer> downs) {
ArrayList<Integer> merged = new ArrayList<Integer>();
while (ups.size() != downs.size()) //Checks if ups and downs arrays are of equal length
{
if (ups.size() > downs.size()) {
downs.add(0); //increases downs array length if it is shorter
}
if (ups.size() < downs.size()) {
ups.add(0); //increases ups array length if it is shorter
}
}
for (int i = 0; i < ups.size(); i++) {
merged.add(ups.get(i) + downs.get(i)); //Adds ups and downs at i, result goes to merged at i
}
return merged;
}

public ArrayList<Integer> list() throws FileNotFoundException {
try //Exception handler
{
Scanner input = new Scanner(new File("p1-in.txt")); //Tries file scanner
} catch (FileNotFoundException pExcept) //If file is not found
{
System.out.println(" Opps! Sorry, could not open 'p01-in.txt' for reading. Stopping )"); //Prints message
System.exit(-1); //Exits System
}

ArrayList<Integer> list = new ArrayList<Integer>();

Scanner input = new Scanner(new File("p1-in.txt")); //Scanner to read from text file
for (int i = 0; input.hasNext() == true; i++) {
i = input.nextInt();
list.add(i);
}
if (input.hasNext() == false) {
input.close();
}
return list;
}

public int total(ArrayList<Integer> runs) {
int sum = 0;
for (int i = 1; i < runs.size(); i++) {
int t = runs.get(i);
sum += t;
}
return sum;
}

public PrintWriter output(int t, ArrayList<Integer> runs) throws FileNotFoundException {
PrintWriter output = new PrintWriter(new File("p1-in.txt"));

output.println("runs_total, " + t);
for (int i = 1; i < runs.size(); i++) {
output.println("runs_" + i + ", " + runs.get(i));
}
output.close();
return output;
}
}
