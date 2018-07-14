/**
 * 键盘事件 
 * 把数写在页面上
 * 随机产生随机数
 */
var box = document.getElementsByClassName("child_box");
var score = 0;//记录分数
var keyMove=true;//如果是结果页的时候，不让动
var sNum=0;
var ifUpOver=false,ifDownOver=false,ifRightOver=false,ifLeftOver=false;
mScore=window.localStorage.getItem("mScore");
var n = new Array();
function getNums(nums,keyM,successNum){
	n=nums;
	keyMove=keyM;
	sNum=successNum;
}

/*开启结果页面*/
function successPage(){
	//alert(sNum+":"+keyMove);
	for(var i=0;i<n.length;i++){
		if(n[i]==sNum){
			document.getElementById("successId").style.display="block";
			document.getElementById("animationSuccessId").style.display="block";
			keyMove=false;
		}
	}
}
/*判断游戏是否over,并开启over界面*/
function gameOver(){
	if(ifDownOver&&ifLeftOver&&ifRightOver&&ifUpOver){
		document.getElementById("failureId").style.display="block";
	}
}
/*生成颜色*/
function colorNum(){
	for(var i=0;i<n.length;i++){
		if(n[i]==2){
			box[i].style.backgroundColor="#FFFCF5";
			box[i].style.color="#A89E93";
			box[i].style.boxShadow="none";
		}else if(n[i]==4){
			//alert(4);
			box[i].style.backgroundColor="#fcf2f2";
			box[i].style.color="#A89E93";
			box[i].style.boxShadow="none";
		}else if(n[i]==8){
			box[i].style.backgroundColor="#faca86";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}else if(n[i]==16){
			box[i].style.backgroundColor="#fabd67";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}else if(n[i]==32){
			box[i].style.backgroundColor="#fab14a";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}else if(n[i]==64){
			box[i].style.backgroundColor="#faa42a";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}
		else if(n[i]==128){
			box[i].style.backgroundColor="#fc9b6c";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}
		else if(n[i]==256){
			box[i].style.backgroundColor="#fa874e";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}
		else if(n[i]==512){
			box[i].style.backgroundColor="#fb722e";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}
		else if(n[i]==1024){
			box[i].style.backgroundColor="#f9641b";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}else if(n[i]==2048){
			box[i].style.backgroundColor="darkorange";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="0px 0px 6px #fbf808";
			box[i].style.boxShadow="none";
		}else if(n[i]==4096){
			box[i].style.backgroundColor="#e10606";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="0px 0px 6px #fc2a2a";
		}else if(n[i]==8192){
			box[i].style.backgroundColor="#04fc33";
			box[i].style.color="#FFFFFF";
			box[i].style.boxShadow="none";
		}else{
			box[i].style.boxShadow="none";
		}
	}
	
	
}
/*把数写到页面上*/
function writeNum(){
	//alert("score:"+score);
	//alert("m:"+mScore);
	//alert(n.length);
	for(var i=0;i<n.length;i++){
		if(n[i]>1000){
			box[i].style.fontSize='30px';
		}else{
			box[i].style.fontSize='40px';
		}
		if(n[i]!=0){
			box[i].innerText=n[i];
			//box[i].style.backgroundColor='#FFFCF5';
			box[i].style.transition="background-color 0.2s ";
			document.getElementById("score").innerText=score;
			if(mScore<=score){
				//alert(mScore);
				mScore=score;
				document.getElementById("mScore").innerText=mScore;
				window.localStorage.setItem("mScore",mScore)
			
			}
		}else{
			box[i].innerText="";
			box[i].style.backgroundColor= '#cdc1b4';
		}
	}
	 colorNum();
	 successPage();
	 gameOver();
	//alert(window.localStorage.getItem("mScore"));
}
/*产生随机数*/
function randNum(){
	var c = Math.floor(Math.random()*16);
	var t=0;
	for(i=0;i<16;i++){//判断n数组是否全不为零
		t++;
		if(n[i]==0){
			break;
		}
	}
	if(n[c]==0){
		if(Math.random()>0.85){
			n[c]=4;
		}else{
			n[c]=2;
		}	
	}else{
		if(t<16){
			randNum();
		}
	}
	
	writeNum();
}




/*按上键*/
function up(){
	var temp=false;//判断是否可以移动，如果移动则产生随机数，否则不产生随机数
	if(keyMove){
		for(var num=0;num<=3;num++){
			for(var j=num;j<=num+8;j=j+4){//向上移
				if(n[j]==0){
					for(var i=j+4;i<=15;i=i+4){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
			if(n[num]==n[num+4]&&n[num]!=0){//合并
				n[num]=n[num+4]*2;
				n[num+4]=0;
				score+=n[num]*2;
				temp=true;
			}else if(n[num+4]==n[num+8]&&n[num+4]!=0){
				n[num+4]=n[num+4]*2;
				n[num+8]=0;
				score+=n[num+4]*2;
				temp=true;
			}else if(n[num+8]==n[num+12]&&n[num+8]!=0){
				n[num+8]=n[num+12]*2;
				n[num+12]=0;
				score+=n[num+8];
				temp=true;
			}
			for(var j=num;j<=num+8;j=j+4){//向上移
				if(n[j]==0){
					for(var i=j+4;i<=15;i=i+4){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
		}
	
	}
	writeNum();
	if(temp){
		randNum();
		ifUpOver=false;
	}else{
		ifUpOver=true;
	}
}
/*按下键*/
function down(){
	var temp=false;
	if(keyMove){
		for(var num=12;num<=15;num++){
			for(var j=num;j>=num-8;j=j-4){//向下移
				if(n[j]==0){
					for(i=j-4;i>=0;i=i-4){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							//alert(1);
							break;
						}
					}
				}
			}
			if(n[num]==n[num-4]&&n[num]!=0){//合并
				n[num]*=2;
				n[num-4]=0;
				score+=n[num];
				temp=true;
			}else if(n[num-4]==n[num-8]&&n[num-4]!=0){
				n[num-4]*=2;
				n[num-8]=0;
				score+=n[num-4];
				temp=true;
			}else if(n[num-8]==n[num-12]&&n[num-8]!=0){
				n[num-8]=n[num-12]*2;
				n[num-12]=0;
				score+=n[num-8];
				temp=true;
			}
			for(var j=num;j>=num-8;j=j-4){//向下移
				if(n[j]==0){
					for(i=j-4;i>=0;i=i-4){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
			
		}
	}
	writeNum();
	if(temp){
		randNum();
		ifDownOver=false;
	}else{
		ifDownOver=true;
	}
}
/*按右键*/
function right(){
	var temp=false;
	if(keyMove){
		for(var num=0;num<=12;num+=4){
			for(var j=num;j<=num+3;j++){//向右移
				if(n[j]==0){
					for(i=j+1;i<=num+3;i++){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
			if(n[num]==n[num+1]&&n[num]!=0){
				n[num]=n[num+1]*2;
				n[num+1]=0;
				score+=n[num];
				temp=true;
			}else if(n[num+1]==n[num+2]&&n[num+1]!=0){
				n[num+1]=n[num+2]*2;
				n[num+2]=0;
				score+=n[num+1];
				temp=true;
			}else if(n[num+2]==n[num+3]&&n[num+2]!=0){
				n[num+2]=n[num+3]*2;
				n[num+3]=0;
				score+=n[num+2];
				temp=true;
			}
			for(var j=num;j<=num+3;j++){//向右移
				if(n[j]==0){
					for(i=j+1;i<=num+3;i++){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
		}
		
	}
	writeNum();
	if(temp){
		randNum();
		ifRightOver=false;
	}else{
		ifRightOver=true;
	}
}
/*按左键*/
function left(){
	var temp=false;
	if(keyMove){
		for(var num=3;num<=15;num+=4){
			for(var j=num;j>=num-3;j--){
				if(n[j]==0){
					for(i=j-1;i>=num-3;i--){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
			if(n[num]==n[num-1]&&n[num]!=0){
				n[num]=n[num-1]*2;
				n[num-1]=0;
				score+=n[num];
				temp=true;
			}else if(n[num-1]==n[num-2]&&n[num-1]!=0){
				n[num-1]=n[num-2]*2;
				n[num-2]=0;
				score+=n[num-1];
				temp=true;
			}else if(n[num-2]==n[num-3]&&n[num-2]!=0){
				n[num-2]=n[num-3]*2;
				n[num-3]=0;
				score+=n[num-2];
				temp=true;
			}
			for(var j=num;j>=num-3;j--){
				if(n[j]==0){
					for(i=j-1;i>=num-3;i--){
						if(n[i]!=0){
							n[j]=n[i];
							n[i]=0;
							temp=true;
							break;
						}
					}
				}
			}
		}
	}
	writeNum();
	if(temp){
		randNum();
		ifLeftOver=false;
	}else{
		ifLeftOver=true;
	}
}

