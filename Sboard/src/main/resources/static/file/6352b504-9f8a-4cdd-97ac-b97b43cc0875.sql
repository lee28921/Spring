-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.34 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- jboard 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jboard` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jboard`;

-- 테이블 jboard.article 구조 내보내기
CREATE TABLE IF NOT EXISTS `article` (
  `no` int NOT NULL AUTO_INCREMENT,
  `parent` int DEFAULT '0',
  `comment` int DEFAULT '0',
  `cate` varchar(20) DEFAULT 'free',
  `title` varchar(255) DEFAULT NULL,
  `content` text NOT NULL,
  `file` tinyint DEFAULT '0',
  `hit` int DEFAULT '0',
  `writer` varchar(20) NOT NULL,
  `regip` varchar(100) NOT NULL,
  `radte` datetime NOT NULL,
  PRIMARY KEY (`no`),
  KEY `writer` (`writer`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`writer`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jboard.file 구조 내보내기
CREATE TABLE IF NOT EXISTS `file` (
  `fno` int NOT NULL AUTO_INCREMENT,
  `ano` int NOT NULL,
  `oriName` varchar(255) NOT NULL,
  `newName` varchar(255) NOT NULL,
  `download` int DEFAULT '0',
  `rdate` datetime NOT NULL,
  PRIMARY KEY (`fno`),
  KEY `ano` (`ano`),
  CONSTRAINT `file_ibfk_1` FOREIGN KEY (`ano`) REFERENCES `article` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jboard.terms 구조 내보내기
CREATE TABLE IF NOT EXISTS `terms` (
  `no` int NOT NULL AUTO_INCREMENT,
  `privacy` varchar(255) DEFAULT NULL,
  `terms` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jboard.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `uid` varchar(20) NOT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `nick` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'USER',
  `zip` varchar(255) DEFAULT NULL,
  `addr1` varchar(255) DEFAULT NULL,
  `addr2` varchar(255) DEFAULT NULL,
  `regip` varchar(100) DEFAULT NULL,
  `ragDate` datetime DEFAULT NULL,
  `LeaveDate` varchar(255) DEFAULT NULL,
  `regDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `nick` (`nick`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `hp` (`hp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- userdb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `userdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `userdb`;

-- 테이블 userdb.boardarticle 구조 내보내기
CREATE TABLE IF NOT EXISTS `boardarticle` (
  `no` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `rdate` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `FKkbwphu2kpy2e4exclw3lmu7hg` (`writer`),
  CONSTRAINT `FKkbwphu2kpy2e4exclw3lmu7hg` FOREIGN KEY (`writer`) REFERENCES `boarduser` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 userdb.boardcomment 구조 내보내기
CREATE TABLE IF NOT EXISTS `boardcomment` (
  `cno` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `rdate` datetime(6) DEFAULT NULL,
  `parent` int DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `FKb76bly2xwsaddwihgdi2c4da0` (`parent`),
  KEY `FKqx2qbnwrs6e6fb64ct1xg79ku` (`writer`),
  CONSTRAINT `FKb76bly2xwsaddwihgdi2c4da0` FOREIGN KEY (`parent`) REFERENCES `boardarticle` (`no`),
  CONSTRAINT `FKqx2qbnwrs6e6fb64ct1xg79ku` FOREIGN KEY (`writer`) REFERENCES `boarduser` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 userdb.boardfile 구조 내보내기
CREATE TABLE IF NOT EXISTS `boardfile` (
  `fno` int NOT NULL AUTO_INCREMENT,
  `oName` varchar(255) DEFAULT NULL,
  `sName` varchar(255) DEFAULT NULL,
  `ano` int DEFAULT NULL,
  PRIMARY KEY (`fno`),
  UNIQUE KEY `UK_4vl92o2xky45q7w09871aro9s` (`ano`),
  CONSTRAINT `FKpfyyfidlnscimwgc4y0fqb8d2` FOREIGN KEY (`ano`) REFERENCES `boardarticle` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 userdb.boarduser 구조 내보내기
CREATE TABLE IF NOT EXISTS `boarduser` (
  `uid` varchar(255) NOT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rdate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 userdb.user1 구조 내보내기
CREATE TABLE IF NOT EXISTS `user1` (
  `uid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `hp` varchar(13) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
