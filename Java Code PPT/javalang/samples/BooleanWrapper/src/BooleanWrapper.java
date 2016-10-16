
class BooleanWrapper {
    
   public static void main(String args[]) {
       
      boolean booleanVar = 1>2;
      Boolean booleanObj = new Boolean("TRue");
      
      /* primitive to object; can also use valueOf 
         method */
      Boolean booleanObj2 = new Boolean(booleanVar);
      
      System.out.println("booleanVar = " + booleanVar);
      System.out.println("booleanObj = " + booleanObj);
      System.out.println("booleanObj2 = " +  
                          booleanObj2);
      System.out.println("compare 2 wrapper objects: " 
                     + booleanObj.equals(booleanObj2));
      
      /* object to primitive */ 
      booleanVar = booleanObj.booleanValue();
      System.out.println("booleanVar = " + booleanVar);
   }
}