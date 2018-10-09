USE [master]
GO
/****** Object:  Database [progeait]    Script Date: 09/10/2018 11:45:54 ******/
CREATE DATABASE [progeait]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'progeait', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\progeait.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'progeait_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\progeait_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [progeait] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [progeait].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [progeait] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [progeait] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [progeait] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [progeait] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [progeait] SET ARITHABORT OFF 
GO
ALTER DATABASE [progeait] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [progeait] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [progeait] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [progeait] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [progeait] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [progeait] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [progeait] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [progeait] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [progeait] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [progeait] SET  DISABLE_BROKER 
GO
ALTER DATABASE [progeait] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [progeait] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [progeait] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [progeait] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [progeait] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [progeait] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [progeait] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [progeait] SET RECOVERY FULL 
GO
ALTER DATABASE [progeait] SET  MULTI_USER 
GO
ALTER DATABASE [progeait] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [progeait] SET DB_CHAINING OFF 
GO
ALTER DATABASE [progeait] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [progeait] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [progeait] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'progeait', N'ON'
GO
USE [progeait]
GO
/****** Object:  Table [dbo].[candidats]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[candidats](
	[idCandidat] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCandidat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[collaborateurs]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[collaborateurs](
	[idCollaborateur] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCollaborateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[epreuves]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[epreuves](
	[idEpreuve] [int] IDENTITY(1,1) NOT NULL,
	[dateDebutValidite] [datetime] NOT NULL,
	[dateFinValidite] [datetime] NOT NULL,
	[tempsEcoule] [time](7) NOT NULL,
	[etat] [varchar](250) NOT NULL,
	[note_obtenue] [varchar](250) NOT NULL,
	[niveau_obtenu] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEpreuve] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[profils]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[profils](
	[codeProfil] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
 CONSTRAINT [PK_profil] PRIMARY KEY CLUSTERED 
(
	[codeProfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[promotions]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[promotions](
	[codePromo] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
 CONSTRAINT [PK_promotion] PRIMARY KEY CLUSTERED 
(
	[codePromo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[propositions]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[propositions](
	[idProposition] [int] IDENTITY(1,1) NOT NULL,
	[enonce] [varchar](250) NOT NULL,
	[estBonne] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idProposition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[questions]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[questions](
	[idQuestion] [int] IDENTITY(1,1) NOT NULL,
	[enonce] [varchar](250) NOT NULL,
	[media] [binary](1) NOT NULL,
	[points] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idQuestion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[questions_tirage]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[questions_tirage](
	[idQuestionTirage] [int] IDENTITY(1,1) NOT NULL,
	[estMarquee] [bit] NOT NULL,
	[numOrdre] [int] NOT NULL,
 CONSTRAINT [PK_Question_Tirage] PRIMARY KEY CLUSTERED 
(
	[idQuestionTirage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[reponses_Tirage]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reponses_Tirage](
	[idReponseTirage] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idReponseTirage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sections_Test]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sections_Test](
	[idSectionTest] [int] IDENTITY(1,1) NOT NULL,
	[nbQuestionATirer] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idSectionTest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tests]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tests](
	[idTest] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[duree] [time](7) NOT NULL,
	[seuil_haut] [varchar](250) NOT NULL,
	[seuil_bas] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[themes]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[themes](
	[idTheme] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTheme] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[utilisateurs]    Script Date: 09/10/2018 11:45:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[utilisateurs](
	[idUtilisateur] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](250) NOT NULL,
	[prenom] [varchar](250) NOT NULL,
	[email] [varchar](250) NOT NULL,
	[motDePasse] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idUtilisateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [email] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[candidats]  WITH CHECK ADD  CONSTRAINT [FK_Candidat_Epreuve] FOREIGN KEY([idCandidat])
REFERENCES [dbo].[epreuves] ([idEpreuve])
GO
ALTER TABLE [dbo].[candidats] CHECK CONSTRAINT [FK_Candidat_Epreuve]
GO
ALTER TABLE [dbo].[candidats]  WITH CHECK ADD  CONSTRAINT [FK_Candidat_Promotion] FOREIGN KEY([idCandidat])
REFERENCES [dbo].[promotions] ([codePromo])
GO
ALTER TABLE [dbo].[candidats] CHECK CONSTRAINT [FK_Candidat_Promotion]
GO
ALTER TABLE [dbo].[epreuves]  WITH CHECK ADD  CONSTRAINT [FK_Epreuve_Question_Tirage] FOREIGN KEY([idEpreuve])
REFERENCES [dbo].[questions_tirage] ([idQuestionTirage])
GO
ALTER TABLE [dbo].[epreuves] CHECK CONSTRAINT [FK_Epreuve_Question_Tirage]
GO
ALTER TABLE [dbo].[propositions]  WITH CHECK ADD  CONSTRAINT [FK_Proposition_Reponse_Tirage] FOREIGN KEY([idProposition])
REFERENCES [dbo].[reponses_Tirage] ([idReponseTirage])
GO
ALTER TABLE [dbo].[propositions] CHECK CONSTRAINT [FK_Proposition_Reponse_Tirage]
GO
ALTER TABLE [dbo].[questions]  WITH CHECK ADD  CONSTRAINT [FK_Question_Proposition] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[propositions] ([idProposition])
GO
ALTER TABLE [dbo].[questions] CHECK CONSTRAINT [FK_Question_Proposition]
GO
ALTER TABLE [dbo].[questions]  WITH CHECK ADD  CONSTRAINT [FK_Question_Question_Tirage] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[questions_tirage] ([idQuestionTirage])
GO
ALTER TABLE [dbo].[questions] CHECK CONSTRAINT [FK_Question_Question_Tirage]
GO
ALTER TABLE [dbo].[questions_tirage]  WITH CHECK ADD  CONSTRAINT [FK_Question_Tirage_Reponse_Tirage] FOREIGN KEY([idQuestionTirage])
REFERENCES [dbo].[reponses_Tirage] ([idReponseTirage])
GO
ALTER TABLE [dbo].[questions_tirage] CHECK CONSTRAINT [FK_Question_Tirage_Reponse_Tirage]
GO
ALTER TABLE [dbo].[sections_Test]  WITH CHECK ADD  CONSTRAINT [FK_Sections_Test_Theme] FOREIGN KEY([idSectionTest])
REFERENCES [dbo].[themes] ([idTheme])
GO
ALTER TABLE [dbo].[sections_Test] CHECK CONSTRAINT [FK_Sections_Test_Theme]
GO
ALTER TABLE [dbo].[tests]  WITH CHECK ADD  CONSTRAINT [FK_Test_Epreuve] FOREIGN KEY([idTest])
REFERENCES [dbo].[epreuves] ([idEpreuve])
GO
ALTER TABLE [dbo].[tests] CHECK CONSTRAINT [FK_Test_Epreuve]
GO
ALTER TABLE [dbo].[tests]  WITH CHECK ADD  CONSTRAINT [FK_Test_Section_Test] FOREIGN KEY([idTest])
REFERENCES [dbo].[sections_Test] ([idSectionTest])
GO
ALTER TABLE [dbo].[tests] CHECK CONSTRAINT [FK_Test_Section_Test]
GO
ALTER TABLE [dbo].[themes]  WITH CHECK ADD  CONSTRAINT [FK_Theme_Question] FOREIGN KEY([idTheme])
REFERENCES [dbo].[questions] ([idQuestion])
GO
ALTER TABLE [dbo].[themes] CHECK CONSTRAINT [FK_Theme_Question]
GO
ALTER TABLE [dbo].[utilisateurs]  WITH CHECK ADD  CONSTRAINT [FK_Utilisateur_Profil] FOREIGN KEY([idUtilisateur])
REFERENCES [dbo].[profils] ([codeProfil])
GO
ALTER TABLE [dbo].[utilisateurs] CHECK CONSTRAINT [FK_Utilisateur_Profil]
GO
USE [master]
GO
ALTER DATABASE [progeait] SET  READ_WRITE 
GO
