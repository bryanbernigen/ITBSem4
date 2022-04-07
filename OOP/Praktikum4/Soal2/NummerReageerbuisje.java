//package Soal2;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// ANDA TIDAK BOLEH MENAMBAH, MENGURANGI, ATAU MENGUBAH NAMA ATRIBUT KELAS
class NummerReageerbuisje {
  private Stack<Integer> contents;      // Isi dari NummerReageerbuisje
  private int capacity;                 // Kapasitas maksimal dari NummerReageerbuisje
  private int filledCap;                // Berapa banyak angka yang telah mengisi NummerReageerbuisje
  
  public NummerReageerbuisje() {
    // Default konstruktor dengan capacity = 3
    this.contents = new Stack<Integer>();
    this.capacity = 3;
    this.filledCap = 0;
  } 

  public NummerReageerbuisje(int cap) {
    // Modified konstruktor dengan capacity = cap
    this.contents = new Stack<Integer>();
    this.capacity = cap;
    this.filledCap = 0;
  }

  public int getCapacity() {
    // getter atribut capacity
    return this.capacity;
  }

  public int getFilledCap() {
    // getter atribut filledCap
    return this.filledCap;
  }

  public void receiveOneSubstance(int substance) {
    // NummerReageerbuisje menerima satu "substance" yaitu angka yang masuk
    if(this.filledCap < this.capacity){
      this.contents.push(substance);
      this.filledCap+=1;
    }
  } 

  public void pour(NummerReageerbuisje other) {
    // NummerReageerbuisje menuangkan isi dari contents ke NummerReageerbuisje other hingga other penuh
    // Note: Angka yang dituangkan terlebih dahulu adalah angka yang paling atas posisinya
    while(!this.contents.isEmpty() && other.getFilledCap() < other.getCapacity()){
      other.receiveOneSubstance(this.contents.pop());
    }
  }

  public void pourAllContents() {
    // NummerReageerbuisje ditumpahkan sepenuhnya, sehigga contents kosong
    // Melakukan println untuk setiap elemen yang tumpah berurut dari yang paling awal tumpah
    while(!this.contents.isEmpty()){
      System.out.println(this.contents.pop());
    }
    this.filledCap = 0;
}

  public void stirSwirl() {
    // contents dari NummerReageerbuisje menjadi terbalik urutannya
    Queue<Integer> temp = new LinkedList<Integer>();
    while(!this.contents.isEmpty()){
      temp.add(this.contents.pop());
    }
    while(!temp.isEmpty()){
      this.contents.push(temp.remove());
    }
}

  public void centrifuge() {
    // contents dari NummerReageerbuisje diurutkan berdasarkan nilai angkanya, 
    // dengan yang terbesar di paling bawah dan yang terkecil di paling atas
    PriorityQueue<Integer> temp = new PriorityQueue<Integer>(this.contents.size(),Collections.reverseOrder());
    while(!this.contents.isEmpty()){
      temp.add(this.contents.pop());
    }
    while(!temp.isEmpty()){
      this.contents.push(temp.poll());
    }
  }
}