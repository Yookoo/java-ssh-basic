package com.young.dao;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.young.po.Article;
import com.young.po.User;
import com.young.util.DateFormatUtils;




public class ArticleDaoImplTest {
	
	ApplicationContext ctx = null;

	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@After
	public void release(){
		ctx = null;
	}

	@Test
	public void testSaveOrUpdate(){
		 ArticleDao articleDao = ctx.getBean(ArticleDao.class);
	

		 Article article = new Article();
		 article.setTitle("让梦想扬帆启程");
		 article.setUserId(1);
		 article.setKeywords("sex");
		 article.setJointime(DateFormatUtils.toyyyyMMddHHmmss(new Date()));
		 article.setCategoryId(1);
		 article.setContent("<p>梦想往往被认为是年轻人的专利，但也不尽然。梦想是不分老少的，它属于每个渴望创造精彩人生的人。在中国历史上，玄奘大师可谓无人不知。他离开长安，只身前往印度取经的时候，刚刚30岁，正值而立之年。在他之前230年，一位年过花甲、年龄有他两倍大的老和尚，也是从长安出发前往印度的，他就是生活在东晋时期的法显。如果我们把玄奘的长征称之为壮举，那么法显的长征则不能不说是奇迹。这告诉我们，成就一番伟业，尽管需要某些外在因素，但它们不是决定性的。真正具有决定性的是认准目标、持之不懈的愿力。人在年轻时，有着健康的体魄与充沛的精力，但思想尚未成熟，经验有待积累。到了老年，思想完全成熟了，经验充分积累了，可体魄和精力却逐渐衰退了。"
		 		+ "这是人生的自然过程，遗憾在所难免。但在法显看来，这些都不重要。去印度取经，是他的一个远大理想。在周围人看来，更像是一个幻想，因为并没有任何理由能够让大家信服，此行非要他亲自去不可。想必在他出发前，一定会有好心人苦口婆心地劝他放弃那种疯狂的想法，悬崖勒马还来得及。毕竟年纪老了，体力差了，前方几万里的跋涉更是太过艰苦、太过危险了，让其他人代替也未尝不可嘛。但是法显还是要去。任何想法在刚刚诞生、尚未付诸于现实的时候，都是一个梦。不过法显这种对梦想的执着，跟年轻人的狂热是不同的。所谓狂热，是由于缺少经验与智慧而草率行事，结果一旦遭遇现实，幼稚的想法即刻便被打回原形。法显则很清楚此行的艰难困苦和自身将要付出的巨大代价。在经过多少日夜的深思熟虑和利弊权衡之后，他的想法逐渐清晰、条理化了。"
		 				+ "于是，梦想就变成了理想，也就是一套能够付诸实践的具体思路，只要坚持做下去，就有成功的希望。在为实现理想的漫漫征途中，年纪与体力，还不是法显面临的最大障碍。真正的障碍是他要放弃前60年来打下的基业，丢下眼前的所有名誉利禄，前往人生地不熟的异邦，从头再来一场二次创业。如果还年轻，他尽可以拼搏进取，就像玄奘那样，反正无所挂碍，即便失败了还有东山再起的机会；可一旦上了年纪，人生的攻守之势就变了，以前是攻者，现在则是守者。守的是什么呢？守成--过去的成绩、成果、成功、成就。人一旦执着这些荣耀，就会更加保守，更加计较，反倒阻碍了自己的继续前进。放弃一切以往的成就，法显不但去了印度，还学会了梵语，搜集抄写了数百万字的经典。他在70多岁的时候回到中国，与他同行的10人里面，只有法显一人完成了夙愿。他九死一生的传奇经历被完整记录在他的作品《佛国记》里。这不仅是一笔巨大的历史文化财富，更是一座人类梦想的丰碑。</p>");
		 article.setClick(0);
		 articleDao.saveOrUpdate(article);
	}
	
}	
