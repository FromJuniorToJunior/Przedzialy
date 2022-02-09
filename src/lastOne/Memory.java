package lastOne;

import java.util.LinkedList;

public class Memory {
    public LinkedList<Section> memory;
    Memory()
    {
        this.memory = new LinkedList<>();
    }

    public void addToMemory(Section section)
    {
        memory.add(section);
    }
    public void printMemory()
    {
        for(int i =0;i<memory.size();i++)
        {
            System.out.println(memory.get(i));
        }
    }
    public void removeFromMemoryById(int id)
    {
        memory.remove(id);
    }
    public void removeAllFromMemory()
    {
        memory.clear();
    }


}
