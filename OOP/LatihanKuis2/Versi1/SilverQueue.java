public class SilverQueue extends Queue <Member>{
    SilverQueue(){
        super();
    }

    public void moveGold(Queue<? super GoldMember> goldenQueue){
        SilverQueue tempQueue = new SilverQueue();
        for (Member m : this.queue) {
            if(m instanceof GoldMember){
                goldenQueue.enqueue((GoldMember)m);
            }
            else{
                tempQueue.enqueue(m);
            }
        }
        this.queue = tempQueue.queue;
    }
}
