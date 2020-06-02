package new1

import scala.util.control.Breaks._
import scala.io.Source
import java.io.File
import java.io.{BufferedWriter, FileWriter, File, PrintWriter}

object Rabbin {
  def main(args:Array[String])
  {
    search("ASDFGHYTEABCDF","ABC")
  }
  def search(txt:String,pat:String)
  {
    var m=txt.length()
    var n=pat.length()
    
    var i:Int=0
    var p:Int=0 //Hash value of pattern
    var t:Int=0 //Hash value of text
    var h:Int=1
    val d:Int=256
    var q:Int=13 //prime number
    
    for(i<-0 until (n-1))
    {
      h= (h*d)%q
    }
    for(i<-0 until n)
    {
      p=(d*p +pat.charAt(i))%q
      t=(d*t +txt.charAt(i))%q
    }
    for(i<-0 to (m-n))
    {
      if(p==t)
      {
        var j:Int=0
        
             while(j<n && txt(i+j)== pat.charAt(j))
             {
               j=j+1
               
                if(j==n)
                  {
                      println("pattern found in index: "+i)
//                    val fw=new FileWriter("Naive.txt",true);
//                    fw.write("pattern found in index : "+i+"\n")   
//                    fw.close()
                  }
             }
      }
      if(i<(m-n))
      {
        t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+n))%q
        
        if(t<0)
          t=(t+q)
      }
    }
  }
}