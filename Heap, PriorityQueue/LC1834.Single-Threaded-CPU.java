class Solution {
    public int[] getOrder(int[][] tasks) {
        // tasks length is important
        int n = tasks.length;

        // Now a task array that is sorted in terms of the time it comes i.e. EnqueueTime
        Task[] taskArray = new Task[n];

        // add all tasks elements in this TaskArray
        // so now onwards we can refer to taskArray
        for(int i = 0; i < n; i++){
            taskArray[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }

        // You need to sort the array based on the enqueueTime as it is the main factor
        Arrays.sort(taskArray, (a,b) -> {
            return Integer.compare(a.enqueueTime, b.enqueueTime);
        });

        // Min heap with conditions listed below
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            // If both task have same processTime compare based on index
            if(a.processingTime == b.processingTime) return Integer.compare(a.index, b.index);

            // If not same just check based on processingTime
            return Integer.compare(a.processingTime, b.processingTime);
        });

        int ansIndex = 0;
        int taskIndex = 0;
        int currTime = 0;
        int[] ansArray = new int[n];

        // We need to mainly fill out the answerarray
        while(ansIndex < n){
            // adding all the eligible tasks inside the priorityQueue
            
            // "taskArray[taskIndex].enqueueTime < currTime" means the task is eligible in current time
            while( taskIndex < n && taskArray[taskIndex].enqueueTime <= currTime){
                pq.offer(taskArray[taskIndex++]);
            }

            if(pq.isEmpty()){
                currTime = taskArray[taskIndex].enqueueTime;
            }

            else{
                // currTime should be increased to the value that has already passed the processing time
                currTime += pq.peek().processingTime;

                // Add it in answerArray
                ansArray[ansIndex++] = pq.poll().index;
            }
        }

        return ansArray;
    }
}

class Task{
    int index;
    int enqueueTime;
    int processingTime;

    Task(int idx, int et, int pt){
        this.index = idx;
        this.enqueueTime = et;
        this.processingTime = pt;
    }
}