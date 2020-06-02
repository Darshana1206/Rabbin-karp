package new1

import scala.util.control.Breaks._
import scala.io.Source
import java.io.File
import java.io.{BufferedWriter, FileWriter, File, PrintWriter}

object Rabbin {
  def main(args:Array[String])
  {
     var s:String= (" ")
    var t:Char=s.charAt(0)
    
    var count:Int=0
    var j:Int=0
    var i:Int=0
    var n:Int=0
    
    var newArr = new Array[Char](100000000) 
    
   for(line <- Source.fromFile("pi.txt").getLines())
   {
     count+=1
     if(count>21)
     {
        var piArr= line.toCharArray()
        var m=piArr.length
        if(m>20)
        {
          for(i<-0 until m)
          {
            if(piArr(i)==t)
            {
              for(j<-i until (m-1))
              {
                piArr(j)=piArr(j+1)
              }
            }
          }
          for(i<-0 until 50)
          {
            newArr(i+n)=piArr(i)  
          }
          n=n+50
        }  
     } 
   }
    search(newArr,"971120")  
  }
  
  
  def search(txt:Array[Char],pat:String)
  {
    var m=txt.length
    var n=pat.length()
    
    var i:Int=0
    var p:Int=0 //Hash value of pattern
    var t:Int=0 //Hash value of text
    var h:Int=1
    val d:Int=10
    var q:Int=13 //prime number
    
    for(i<-0 until (n-1))
    {
      h= (h*d)%q
    }
    for(i<-0 until n)
    {
      p=(d*p +pat.charAt(i))%q
      t=(d*t +txt(i))%q
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
                    val fw=new FileWriter("Rabbin.txt",true);
                    fw.write("pattern found in index : "+i+"\n")   
                    fw.close()
                  }
             }
      }
      if(i<(m-n))
      {
        t=(d*(t-txt(i)*h)+txt(i+n))%q
        
        if(t<0)
          t=(t+q)
      }
    }
  }
}