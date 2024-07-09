package results_competition.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDriversResult {
    
    public List<DriversResult> getDriversResult(int año){

        List<DriversResult> listaDriversLocal = new ArrayList<>();
            
        Dbconexion conn = new Dbconexion();
        
        try {
            String consulta = "SELECT\n"
					+ "    r.year,\n"
					+ "    d.forename,\n"
					+ "    d.surname,\n"
					+ "    COUNT(CASE WHEN res.position = 1 THEN 1 END) AS wins,\n"
					+ "    SUM(res.points) AS total_points,\n"
					+ "    RANK() OVER (PARTITION BY r.year ORDER BY SUM(res.points) DESC) AS season_rank\n"
					+ "FROM\n"
					+ "    results res\n"
					+ "JOIN\n"
					+ "    races r ON res.race_id = r.race_id\n"
					+ "JOIN\n"
					+ "    drivers d ON res.driver_id = d.driver_id\n"
					+ "\n"
					+ "WHERE r.year = ? \n"
					+ "GROUP BY\n"
					+ "    r.year, d.driver_id, d.forename, d.surname\n"
					+ "ORDER BY\n"
					+ "    r.year, season_rank;";

            PreparedStatement statement = conn.establecerConexion().prepareStatement(consulta);
            statement.setInt(1, año);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                DriversResult objDriversResult = new DriversResult();
                int year = Integer.parseInt(rs.getString("year"));
                objDriversResult.setYear(year);
                objDriversResult.setForename(rs.getString("forename"));
                objDriversResult.setSurname(rs.getString("surname"));
                objDriversResult.setWins(rs.getInt("wins"));
                objDriversResult.setTotal_points(rs.getInt("total_points"));
                objDriversResult.setSeason_rank(rs.getInt("season_rank"));

                listaDriversLocal.add(objDriversResult);
            }

            
        } catch (Exception e) {
            System.out.println("No se completo la carga de los datos.");
        }

        return listaDriversLocal;
    }


    public static void main(String[] args) {
        RepositoryDriversResult objDriversResult = new RepositoryDriversResult();
        List<DriversResult> l_s = objDriversResult.getDriversResult(2004);

        // Imprimir encabezado de la tabla
		System.out.printf("%-10s %-10s %8s%n", "Wins", "Total Points", "Rank");

		// Imprimir cada registro con formato
        for (DriversResult rs : l_s) {
            System.out.printf("%-10d %-15d  %-10d%n",				
                    rs.getWins(),
                    rs.getTotal_points(),
                    rs.getSeason_rank());
        }
    }
}
