// https://leetcode.com/problems/employee-importance/

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<employees.size(); i++)
        {
            map.put(employees.get(i).id, i);
        }
        return helperDFS(employees, id, map);
    }
    
    static int helperDFS(List<Employee> employees, int id, Map<Integer,Integer> map)
    {   
        int i = map.get(id);
        int value = employees.get(i).importance;
        for(int subordinate : employees.get(i).subordinates)
        {
            value += helperDFS(employees, subordinate, map);
        }
        return value;
    }
}