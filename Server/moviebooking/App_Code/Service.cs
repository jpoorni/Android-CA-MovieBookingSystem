using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using MovieLibrary1;

public class Service : IService
{
    //Movie
    public string[] List()
    {
        return Movie.List();
    }

    public WCF_Movie GetMovie(string movieID)
    {
        Movie m = Movie.GetMovie(movieID);
        return new WCF_Movie(m.MovieID,m.MovieName,m.TheatreID,m.MovieReview,m.TicketPrice,m.MovieSeats);
    }

    public WCF_Theatre[] GetMovieTheatres(string movieName)
    {
        List<WCF_Theatre> t1 = new List<WCF_Theatre>();

        //Theatre[] t = Movie.GetMovieTheatres(movieName);
        //t.CopyTo(t1,t.Length);
        foreach (Theatre r in  Movie.GetMovieTheatres(movieName))
        {
            t1.Add(new WCF_Theatre(r.TheatreID, r.TheatreName, r.TheatreAddress1, r.TheatreAddress2, r.Pincode,r.Long,r.Latt));
        }
        return t1.ToArray <WCF_Theatre>();
    }

    
    //Theatre
    public string[] ListTheatre()
    {
        return Theatre.ListTheatre();
    }

    public WCF_Theatre GetTheatre(string theatreID)
    {
        Theatre t = Theatre.GetTheatre(theatreID);
        return new WCF_Theatre(t.TheatreID, t.TheatreName, t.TheatreAddress1, t.TheatreAddress2, t.Pincode,t.Long,t.Latt);
    }


}