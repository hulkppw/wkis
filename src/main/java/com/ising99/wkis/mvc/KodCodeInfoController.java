package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.domain.CmdInfo;
import com.ising99.wkis.domain.KodCodeInfo;
import com.ising99.wkis.parameter.KodCodeInfoParam;
import com.ising99.wkis.service.KodCodeInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

import static com.ising99.wkis.utils.RandomNumbers.getRandom;

/**
 * Created by Administrator on 2014-12-06.
 */
@Controller
@RequestMapping("koic")
public class KodCodeInfoController  extends BaseController {
    private static final Logger logger = Logger.getLogger(KodCodeInfoController.class);

    @Resource
    KodCodeInfoService kodCodeInfoService;
    @RequestMapping("/vo")
    @ResponseBody
    /**
     * http://127.0.0.1:8080/wkis/koic/vo?mac=201412mac&sn=201412sn&koic=201412koic
     */
    public CmdInfo getVo(String mac, String sn, String koic) throws Exception {

        CmdInfo cmdInfo=null;
        try
        {
            if (mac == null || "".equals(mac) || sn == null || "".equals(sn)
                    || koic == null || "".equals(koic))
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(-101);// 参数有误
                cmdInfo.setMsg("参数有误");
                return cmdInfo;
            }
            KodCodeInfo kodCodeInfo = new KodCodeInfo();
            KodCodeInfo vo = new KodCodeInfo();
            vo.setId(1);
            vo.setHnuserid(koic);
            vo.setSncode(sn);
            vo.setMac(mac);
            kodCodeInfo = kodCodeInfoService.getVo(vo);
            if (kodCodeInfo != null)
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(0);//
                cmdInfo.setMsg("");
                return cmdInfo;
            } else
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(-102);//
                cmdInfo.setMsg("记录不存在");
                return cmdInfo;
            }

            // return kodCodeInfo;
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.toString(),e);
            cmdInfo = new CmdInfo();
            cmdInfo.setCmd2(-500);// 记录已存在
            cmdInfo.setMsg("运行错误");
            return cmdInfo;
        }


    }

//http://127.0.0.1:8080/koic/add?mac=201412mac&sn=201412sn&koic=201412koic
    @RequestMapping("/add")
    @ResponseBody
    public CmdInfo add(String mac, String sn, String koic) throws Exception {

        CmdInfo cmdInfo = null;
        KodCodeInfo kodCodeInfo = null;
        try
        {
            if (mac == null || "".equals(mac) || sn == null || "".equals(sn)
                    || koic == null || "".equals(koic))
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(-101);// 参数有误
                cmdInfo.setMsg("参数有误");
                return cmdInfo;
            }
            KodCodeInfo vo = new KodCodeInfo();
            vo.setId(1);
            vo.setHnuserid(koic);
            vo.setSncode(sn);
            vo.setMac(mac);
            vo.setStated(0);
//			String stra = RandomNumbers.getRandom(12);
//			vo.setRandusercode(stra);

			/*kodCodeInfo = kodCodeInfoService.getVo(vo);
			if (kodCodeInfo != null)
			{
				cmdInfo = new CmdInfo();
				cmdInfo.setCmd2(-102);//
				cmdInfo.setMsg(kodCodeInfo.getRandusercode());
				return cmdInfo;
			}
*/
            kodCodeInfo = kodCodeInfoService.isExists(vo);
            {
                if (kodCodeInfo != null)
                {
                    cmdInfo = new CmdInfo();
                    cmdInfo.setCmd2(-103);//
                    cmdInfo.setMsg("MAC,SN，KOIC至少有一项已经存在");
                    return cmdInfo;
                }
            }

            // int id=kodCodeInfoService.insert(vo);
            int id = 0;
			/*int nums = 0;
			while ((id = kodCodeInfoService.insert(vo)) <= 0)
			{
				nums++;
				if (nums > 3)
					break;
			}*/
            id = kodCodeInfoService.insert(vo);
            if (id > 0)
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(0);// 添加成功
                cmdInfo.setMsg("");
                return cmdInfo;
            } else
            {
                cmdInfo = new CmdInfo();
                cmdInfo.setCmd2(-100);// 记录已存在
                cmdInfo.setMsg("添加失败");
                return cmdInfo;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.toString(),e);
            cmdInfo = new CmdInfo();
			/*if (kodCodeInfo != null)
			{
				cmdInfo.setCmd2(-102);//
				cmdInfo.setMsg(kodCodeInfo.getRandusercode());
			} else
			{
				cmdInfo.setCmd2(-500);//
				cmdInfo.setMsg("run is error");
			}*/
            cmdInfo.setCmd2(-500);//
            cmdInfo.setMsg("run is error");
            return cmdInfo;
            // throw new Exception("xw");
            // return 0;
        }

    }

}
