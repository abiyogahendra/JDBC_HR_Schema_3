/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Job;

/**
 *
 * @author putug
 */
public class Job {
    
    public Job(){}
    
    public Job(String id, String title, int minSalary, int maxSalary){
        _id = id;
        _title = title;
        _minSalary = minSalary;
        _maxSalary = maxSalary;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getMinSalary() {
        return _minSalary;
    }

    public void setMinSalary(int _minSalary) {
        this._minSalary = _minSalary;
    }

    public int getMaxSalary() {
        return _maxSalary;
    }

    public void setMaxSalary(int _maxSalary) {
        this._maxSalary = _maxSalary;
    }
    private String _id;
    private String _title;
    private int _minSalary;
    private int _maxSalary;
    
    @Override
    public String toString(){
        return String.format("%s - %s - %d - %d", getId(), getTitle(), getMinSalary(), getMaxSalary());
    }
}
