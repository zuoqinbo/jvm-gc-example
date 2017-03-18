public class MemorySpaceAndAllocation{
    public static void main(String[] args) throws Exception{ 
        Thread.sleep(2000);
        // should allocate from TLAB
        MemoryObject1 object=new MemoryObject1(new byte[1024]);
        Thread.sleep(2000);
        // should allocate from Eden space,not TLAB
        MemoryObject1 newObject=new MemoryObject1(new byte[1024*1024*4]);
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(2000);
        object=new MemoryObject1(new byte[1024]);
        Thread.sleep(2000);
        // should allocate from Eden space,not TLAB
        newObject=new MemoryObject1(new byte[1024*1024*4]);
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(2000);
    }
}

class MemoryObject1{
    private byte[] bytes;
    public byte[] getBytes(){
        return bytes;
    }
    public MemoryObject1(byte[] bytes){
        this.bytes=bytes;
    }
}
