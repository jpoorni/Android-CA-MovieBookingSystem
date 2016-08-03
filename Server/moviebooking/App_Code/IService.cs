using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
 
[ServiceContract]
public interface IService
{
    //Movie 
    [OperationContract]
    [WebGet(UriTemplate = "/List", ResponseFormat = WebMessageFormat.Json)]
    string[] List();
 
    [OperationContract]
    [WebGet(UriTemplate = "/GetMovie/{movieID}", ResponseFormat = WebMessageFormat.Json)]
    WCF_Movie GetMovie(string movieID);

    [OperationContract]
    [WebGet(UriTemplate = "/GetMovieTheatres/{movieName}", ResponseFormat = WebMessageFormat.Json)]
    WCF_Theatre[] GetMovieTheatres(string movieName);


    //Theatre
    [OperationContract]
    [WebGet(UriTemplate = "/ListTheatre", ResponseFormat = WebMessageFormat.Json)]
    string[] ListTheatre();

    [OperationContract]
    [WebGet(UriTemplate = "/GetTheatre/{theatreID}", ResponseFormat = WebMessageFormat.Json)]
    WCF_Theatre GetTheatre(string theatreID);

}

[DataContract]
public class WCF_Movie
{
    [DataMember]
    public string MovieID;

    [DataMember]
    public string MovieName;

    [DataMember]
    public string MovieReview;

    [DataMember]
    public string TheatreID;

    [DataMember]
    public decimal TicketPrice;

    [DataMember]
    public int MovieSeats;
    public WCF_Movie(string movieID, string movieName, string theatreID, string movieReview, decimal ticketPrice, int movieSeats)
    {
        this.MovieID = movieID;
        this.MovieName = movieName;
        this.TheatreID = theatreID;
        this.MovieReview = movieReview;
        this.TicketPrice = ticketPrice;
        this.MovieSeats = movieSeats;
    }
}

    //Theatre
    [DataContract]
    public class WCF_Theatre {

    [DataMember]
    public string TheatreID;
 
    [DataMember]
    public string TheatreName;
 
    [DataMember]
    public string TheatreAddress1;

    [DataMember]
    public string TheatreAddress2;

    [DataMember]
    public string Pincode;

    [DataMember]
    public string Long;

    [DataMember]
    public string Latt;

 
    public WCF_Theatre(string theatreID, string theatreName, string theatreAddress1, string theatreAddress2, string pincode,string Long,string latt) {
        this.TheatreID= theatreID;
        this.TheatreName = theatreName;
        this.TheatreAddress1 = theatreAddress1;
        this.TheatreAddress2 = theatreAddress2;
        this.Pincode = pincode;
        this.Long = Long;
        this.Latt = latt;
    }
 }