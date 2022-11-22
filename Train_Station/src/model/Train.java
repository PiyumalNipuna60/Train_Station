package model;

public class Train {
    private String trainId;
    private String trainName;
    private String startTime;
    private String EndTime;
    private String trainFrom;
    private String trainTo;

    public Train(String text, String txtTrainNameText, String txtStartTimeText, String txtEndTimeText, Object value, Object cmbTrainToValue) {
    }

    public Train(String trainId, String trainName, String startTime, String endTime, String trainFrom, String trainTo) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.startTime = startTime;
        EndTime = endTime;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", trainName='" + trainName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", trainFrom='" + trainFrom + '\'' +
                ", trainTo='" + trainTo + '\'' +
                '}';
    }
}
