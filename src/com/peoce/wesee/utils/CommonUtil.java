class CommonUtil{
  public static Integer[] int2Integer(int [] array){
    int len=array.length;
    Integer [] temp=new Integer[len];
    int count=0;
    for(int i:array){
      temp[count++]=i;
    }
    return temp;
  }
}
