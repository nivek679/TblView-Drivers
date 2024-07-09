package results_competition.Model;

public class DriversResult {
    private int year;
    private String forename;
    private String surname;
    private int wins;
    private int total_points;
    private int season_rank;

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getForename() {
        return forename;
    }
    public void setForename(String forename) {
        this.forename = forename;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getTotal_points() {
        return total_points;
    }
    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }
    public int getSeason_rank() {
        return season_rank;
    }
    public void setSeason_rank(int season_rank) {
        this.season_rank = season_rank;
    }

}
