package com.image_processing.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class PercentageCheck {

		// lower case averages
		private static double[] a_first = new double[] {0.266,	0.152,	0.212,	0.371};
		private static double[] a_second = new double[] {0.243,	0.159,	0.117,	0.482};
		private static double[] a_third = new double[] {0.045,	0.624,	0.214,	0.116};
		private static double[] a_fourth = new double[] {0.357,	0.114,	0.425,	0.103};
		
		private static double[] b_first = new double[] {0.558,	0.132,	0.058,	0.252};
		private static double[] b_second = new double[] {0.019,	0.479,	0.000,	0.502};
		private static double[] b_third = new double[] {0.007,	0.585,	0.376,	0.033};
		private static double[] b_fourth = new double[] {0.527,	0.123,	0.350,	0.000};
		
		private static double[] c_first = new double[] {0.339,	0.107,	0.000,	0.553};
		private static double[] c_second = new double[] {0.141,	0.403,	0.420,	0.036};
		private static double[] c_third = new double[] {0.143,	0.379,	0.041,	0.437};
		private static double[] c_fourth = new double[] {0.312,	0.138,	0.549,	0.000};
				
		private static double[] d_first = new double[] {0.436,	0.015,	0.055,	0.494};
		private static double[] d_second = new double[] {0.122,	0.640,	0.010,	0.228};
		private static double[] d_third = new double[] {0.074,	0.527,	0.344,	0.055};
		private static double[] d_fourth = new double[] {0.483,	0.108,	0.395,	0.014};
			
		private static double[] e_first = new double[] {0.357,	0.071,	0.000,	0.572};
		private static double[] e_second = new double[] {0.000,	0.402,	0.483,	0.115};
		private static double[] e_third = new double[] {0.128,	0.335,	0.072,	0.465};
		private static double[] e_fourth = new double[] {0.325,	0.100,	0.575,	0.000};
		
		private static double[] f_first = new double[] {0.543,	0.000,	0.114,	0.344};
		private static double[] f_second = new double[] {0.058,	0.384,	0.258,	0.300};
		private static double[] f_third = new double[] {0.000,	0.690,	0.168,	0.142};
		private static double[] f_fourth = new double[] {0.503,	0.134,	0.306,	0.057};

		private static double[] g_first = new double[] {0.441,	0.037,	0.026,	0.496};
		private static double[] g_second = new double[] {0.000,	0.642,	0.254,	0.104};
		private static double[] g_third = new double[] {0.150,	0.251,	0.363,	0.235};
		private static double[] g_fourth = new double[] {0.303,	0.142,	0.342,	0.212};
				
		private static double[] h_first = new double[] {0.414,	0.252,	0.036,	0.297};
		private static double[] h_second = new double[] {0.007,	0.624,	0.116,	0.253};
		private static double[] h_third = new double[] {0.502,	0.189,	0.284,	0.025};
		private static double[] h_fourth = new double[] {0.371,	0.359,	0.225,	0.044};

		private static double[] i_first = new double[] {0.705,	0.000,	0.055,	0.241};
		private static double[] i_second = new double[] {0.008,	0.807,	0.000,	0.186};
		private static double[] i_third = new double[] {0.000,	0.755,	0.173,	0.073};
		private static double[] i_fourth = new double[] {0.649,	0.000,	0.304,	0.048};
		
		private static double[] j_first = new double[] {0.68,	0.00,	0.07,	0.25};
		private static double[] j_second = new double[] {0.00,	0.92,	0.00,	0.08};
		private static double[] j_third = new double[] {0.00,	0.92,	0.00,	0.08};
		private static double[] j_fourth = new double[] {0.00,	0.93,	0.00,	0.07};
		
		private static double[] k_first = new double[] {0.389,	0.351,	0.040,	0.218};
		private static double[] k_second = new double[] {0.122,	0.328,	0.212,	0.338};
		private static double[] k_third = new double[] {0.238,	0.271,	0.321,	0.170};
		private static double[] k_fourth = new double[] {0.366,	0.307,	0.263,	0.062};
				
		private static double[] l_first = new double[] {0.777,	0.000,	0.045,	0.178};
		private static double[] l_second = new double[] {0.006,	0.837,	0.009,	0.149};
		private static double[] l_third = new double[] {0.000,	0.826,	0.116,	0.058};
		private static double[] l_fourth = new double[] {0.706,	0.003,	0.253,	0.038};
				
		private static double[] m_first = new double[] {0.243,	0.128,	0.026,	0.606};
		private static double[] m_second = new double[] {0.365,	0.369,	0.209,	0.058};
		private static double[] m_third = new double[] {0.340,	0.346,	0.268,	0.046};
		private static double[] m_fourth = new double[] {0.220,	0.429,	0.309,	0.042};
				
		private static double[] n_first = new double[] {0.331,	0.079,	0.038,	0.552};
		private static double[] n_second = new double[] {0.055,	0.636,	0.232,	0.078};
		private static double[] n_third = new double[] {0.511,	0.224,	0.233,	0.033};
		private static double[] n_fourth = new double[] {0.289,	0.383,	0.266,	0.064};
		
		private static double[] o_first = new double[] {0.498,	0.000,	0.000,	0.502};
		private static double[] o_second = new double[] {0.000,	0.504,	0.002,	0.494};
		private static double[] o_third = new double[] {0.000,	0.590,	0.410,	0.000};
		private static double[] o_fourth = new double[] {0.450,	0.002,	0.549,	0.000};
		
		private static double[] p_first = new double[] {0.533,	0.016,	0.051,	0.400};
		private static double[] p_second = new double[] {0.006,	0.609,	0.041,	0.345};
		private static double[] p_third = new double[] {0.060,	0.423,	0.465,	0.053};
		private static double[] p_fourth = new double[] {0.467,	0.188,	0.297,	0.048};
		
		private static double[] q_first = new double[] {0.527,	0.006,	0.010,	0.457};
		private static double[] q_second = new double[] {0.014,	0.721,	0.015,	0.250};
		private static double[] q_third = new double[] {0.193,	0.409,	0.305,	0.092};
		private static double[] q_fourth = new double[] {0.367,	0.129,	0.482,	0.022};
				
		private static double[] r_first = new double[] {0.523,	0.006,	0.070,	0.402};
		private static double[] r_second = new double[] {0.039,	0.337,	0.320,	0.304};
		private static double[] r_third = new double[] {0.006,	0.820,	0.110,	0.064};
		private static double[] r_fourth = new double[] {0.464,	0.135,	0.336,	0.064};
		
		private static double[] s_first = new double[] {0.293,	0.202,	0.060,	0.445};
		private static double[] s_second = new double[] {0.115,	0.291,	0.307,	0.287};
		private static double[] s_third = new double[] {0.211,	0.283,	0.480,	0.025};
		private static double[] s_fourth = new double[] {0.207,	0.196,	0.233,	0.364};
		
		private static double[] t_first = new double[] {};
		private static double[] t_second = new double[] {};
		private static double[] t_third = new double[] {};
		private static double[] t_fourth = new double[] {};
		
		private static double[] u_first = new double[] {};
		private static double[] u_second = new double[] {};
		private static double[] u_third = new double[] {};
		private static double[] u_fourth = new double[] {};
		
		private static double[] v_first = new double[] {0.354,	0.164,	0.165,	0.317};
		private static double[] v_second = new double[] {0.373,	0.257,	0.041,	0.329};
		private static double[] v_third = new double[] {0.032,	0.587,	0.240,	0.142};
		private static double[] v_fourth = new double[] {0.325,	0.294,	0.338,	0.042};
		
		private static double[] w_first = new double[] {0.324,	0.200,	0.097,	0.379};
		private static double[] w_second = new double[] {0.243,	0.349,	0.107,	0.301};
		private static double[] w_third = new double[] {0.275,	0.381,	0.323,	0.021};
		private static double[] w_fourth = new double[] {0.263,	0.395,	0.264,	0.078};

		private static double[] x_first = new double[] {};
		private static double[] x_second = new double[] {};
		private static double[] x_third = new double[] {};
		private static double[] x_fourth = new double[] {};
		
		private static double[] y_first = new double[] {};
		private static double[] y_second = new double[] {};
		private static double[] y_third = new double[] {};
		private static double[] y_fourth = new double[] {};
		
		private static double[] z_first = new double[] {};
		private static double[] z_second = new double[] {};
		private static double[] z_third = new double[] {};
		private static double[] z_fourth = new double[] {};
		

		// upper case averages
		private static double[] A_first = new double[] {0.419,	0.202,	0.000,	0.380};
		private static double[] A_second = new double[] {0.000,	0.637,	0.087,	0.276};
		private static double[] A_third = new double[] {0.262,	0.138,	0.555,	0.045};
		private static double[] A_fourth = new double[] {0.374,	0.173,	0.256,	0.198};
		
		private static double[] B_first = new double[] {0.487,	0.000,	0.063,	0.450};
		private static double[] B_second = new double[] {0.000,	0.514,	0.106,	0.380};
		private static double[] B_third = new double[] {0.000,	0.529,	0.359,	0.112};
		private static double[] B_fourth = new double[] {0.448,	0.010,	0.480,	0.061};
		
		private static double[] C_first = new double[] {0.326,	0.114,	0.000,	0.560};
		private static double[] C_second = new double[] {0.145,	0.386,	0.449,	0.020};
		private static double[] C_third = new double[] {0.138,	0.363,	0.037,	0.462};
		private static double[] C_fourth = new double[] {0.303,	0.143,	0.554,	0.000};
		
		private static double[] D_first = new double[] {0.488,	0.000,	0.065,	0.447};
		private static double[] D_second = new double[] {0.000,	0.497,	0.000,	0.503};
		private static double[] D_third = new double[] {0.000,	0.545,	0.456,	0.000};
		private static double[] D_fourth = new double[] {0.459,	0.000,	0.479,	0.063};
		
		private static double[] E_first = new double[] {0.313,	0.126,	0.068,	0.494};
		private static double[] E_second = new double[] {0.078,	0.312,	0.313,	0.299};
		private static double[] E_third = new double[] {0.087,	0.266,	0.313,	0.333};
		private static double[] E_fourth = new double[] {0.295,	0.130,	0.504,	0.071};
				
		private static double[] F_first = new double[] {0.395,	0.004,	0.051,	0.550};
		private static double[] F_second = new double[] {0.057,	0.403,	0.415,	0.126};
		private static double[] F_third = new double[] {0.098,	0.310,	0.322,	0.269};
		private static double[] F_fourth = new double[] {0.367,	0.272,	0.263,	0.097};
		
		private static double[] G_first = new double[] {0.278,	0.196,	0.019,	0.506};
		private static double[] G_second = new double[] {0.124,	0.407,	0.379,	0.090};
		private static double[] G_third = new double[] {0.245,	0.141,	0.148,	0.466};
		private static double[] G_fourth = new double[] {0.255,	0.232,	0.513,	0.000};

		private static double[] H_first = new double[] {0.308,	0.265,	0.076,	0.353};
		private static double[] H_second = new double[] {0.265,	0.348,	0.081,	0.306};
		private static double[] H_third = new double[] {0.299,	0.314,	0.319,	0.069};
		private static double[] H_fourth = new double[] {0.293,	0.295,	0.333,	0.078};
				
		private static double[] I_first = new double[] {0.705,	0.000,	0.077,	0.219};
		private static double[] I_second = new double[] {0.000,	0.719,	0.086,	0.195};
		private static double[] I_third = new double[] {0.000,	0.784,	0.137,	0.080};
		private static double[] I_fourth = new double[] {0.650,	0.004,	0.273,	0.074};

		private static double[] J_first = new double[] {0.541,	0.119,	0.078,	0.263};
		private static double[] J_second = new double[] {0.000,	0.760,	0.136,	0.103};
		private static double[] J_third = new double[] {0.208,	0.274,	0.502,	0.016};
		private static double[] J_fourth = new double[] {0.427,	0.203,	0.031,	0.339};
		
		private static double[] K_first = new double[] {0.380,	0.210,	0.071,	0.339};
		private static double[] K_second = new double[] {0.093,	0.353,	0.264,	0.292};
		private static double[] K_third = new double[] {0.200,	0.249,	0.340,	0.209};
		private static double[] K_fourth = new double[] {0.328,	0.307,	0.274,	0.091};
				
		private static double[] L_first = new double[] {0.505,	0.116,	0.063,	0.316};
		private static double[] L_second = new double[] {0.000,	0.824,	0.069,	0.108};
		private static double[] L_third = new double[] {0.088,	0.229,	0.263,	0.418};
		private static double[] L_fourth = new double[] {0.463,	0.000,	0.482,	0.057};

		private static double[] M_first = new double[] {0.358,	0.293,	0.029,	0.320};
		private static double[] M_second = new double[] {0.188,	0.454,	0.147,	0.211};
		private static double[] M_third = new double[] {0.434,	0.297,	0.244,	0.022};
		private static double[] M_fourth = new double[] {0.396,	0.349,	0.198,	0.060};
		
		private static double[] N_first = new double[] {0.276,	0.315,	0.043,	0.366};
		private static double[] N_second = new double[] {0.345,	0.380,	0.069,	0.205};
		private static double[] N_third = new double[] {0.389,	0.254,	0.358,	0.000};
		private static double[] N_fourth = new double[] {0.283,	0.464,	0.185,	0.067};
		
		private static double[] O_first = new double[] {0.495,	0.000,	0.000,	0.505};
		private static double[] O_second = new double[] {0.000,	0.500,	0.000,	0.500};
		private static double[] O_third = new double[] {0.000,	0.558,	0.442,	0.000};
		private static double[] O_fourth = new double[] {0.460,	0.001,	0.539,	0.000};
		
		private static double[] P_first = new double[] {0.509,	0.000,	0.067,	0.424};
		private static double[] P_second = new double[] {0.000,	0.524,	0.059,	0.417};
		private static double[] P_third = new double[] {0.005,	0.405,	0.529,	0.062};
		private static double[] P_fourth = new double[] {0.474,	0.153,	0.307,	0.066};

		private static double[] Q_first = new double[] {0.481,	0.001,	0.004,	0.514};
		private static double[] Q_second = new double[] {0.000,	0.631,	0.039,	0.330};
		private static double[] Q_third = new double[] {0.051,	0.391,	0.387,	0.171};
		private static double[] Q_fourth = new double[] {0.412,	0.012,	0.573,	0.003};
		
		private static double[] R_first = new double[] {0.357,	0.054,	0.045,	0.545};
		private static double[] R_second = new double[] {0.000,	0.589,	0.164,	0.247};
		private static double[] R_third = new double[] {0.328,	0.176,	0.436,	0.060};
		private static double[] R_fourth = new double[] {0.338,	0.270,	0.302,	0.090};
		
		private static double[] S_first = new double[] {0.295,	0.208,	0.083,	0.414};
		private static double[] S_second = new double[] {0.131,	0.265,	0.307,	0.297};
		private static double[] S_third = new double[] {0.217,	0.297,	0.445,	0.040};
		private static double[] S_fourth = new double[] {0.241,	0.175,	0.231,	0.353};
		
		private static double[] T_first = new double[] {};
		private static double[] T_second = new double[] {};
		private static double[] T_third = new double[] {};
		private static double[] T_fourth = new double[] {};
		
		private static double[] U_first = new double[] {};
		private static double[] U_second = new double[] {};
		private static double[] U_third = new double[] {};
		private static double[] U_fourth = new double[] {};
		
		private static double[] V_first = new double[] {0.341,	0.189,	0.193,	0.277};
		private static double[] V_second = new double[] {0.397,	0.282,	0.008,	0.313};
		private static double[] V_third = new double[] {0.074,	0.514,	0.232,	0.180};
		private static double[] V_fourth = new double[] {0.322,	0.308,	0.337,	0.032};
				
		private static double[] W_first = new double[] {0.335,	0.246,	0.091,	0.328};
		private static double[] W_second = new double[] {0.285,	0.339,	0.090,	0.286};
		private static double[] W_third = new double[] {0.313,	0.371,	0.294,	0.021};
		private static double[] W_fourth = new double[] {0.264,	0.407,	0.252,	0.077};
		
		private static double[] X_first = new double[] {};
		private static double[] X_second = new double[] {};
		private static double[] X_third = new double[] {};
		private static double[] X_fourth = new double[] {};
		
		private static double[] Y_first = new double[] {};
		private static double[] Y_second = new double[] {};
		private static double[] Y_third = new double[] {};
		private static double[] Y_fourth = new double[] {};	
		
		private static double[] Z_first = new double[] {};
		private static double[] Z_second = new double[] {};
		private static double[] Z_third = new double[] {};
		private static double[] Z_fourth = new double[] {};	
		
		
		
		// numbers case averages
		private static double[] Zero_first = new double[] {};
		private static double[] Zero_second = new double[] {};
		private static double[] Zero_third = new double[] {};
		private static double[] Zero_fourth = new double[] {};	
		
		private static double[] One_first = new double[] {};
		private static double[] One_second = new double[] {};
		private static double[] One_third = new double[] {};
		private static double[] One_fourth = new double[] {};	
		
		private static double[] Two_first = new double[] {};
		private static double[] Two_second = new double[] {};
		private static double[] Two_third = new double[] {};
		private static double[] Two_fourth = new double[] {};	
		
		private static double[] Three_first = new double[] {};
		private static double[] Three_second = new double[] {};
		private static double[] Three_third = new double[] {};
		private static double[] Three_fourth = new double[] {};	
		
		private static double[] Four_first = new double[] {};
		private static double[] Four_second = new double[] {};
		private static double[] Four_third = new double[] {};
		private static double[] Four_fourth = new double[] {};	
		
		private static double[] Five_first = new double[] {};
		private static double[] Five_second = new double[] {};
		private static double[] Five_third = new double[] {};
		private static double[] Five_fourth = new double[] {};	
		
		private static double[] Six_first = new double[] {};
		private static double[] Six_second = new double[] {};
		private static double[] Six_third = new double[] {};
		private static double[] Six_fourth = new double[] {};	
		
		private static double[] Seven_first = new double[] {};
		private static double[] Seven_second = new double[] {};
		private static double[] Seven_third = new double[] {};
		private static double[] Seven_fourth = new double[] {};	
		
		private static double[] Eight_first = new double[] {};
		private static double[] Eight_second = new double[] {};
		private static double[] Eight_third = new double[] {};
		private static double[] Eight_fourth = new double[] {};	
		
		private static double[] Nine_first = new double[] {};
		private static double[] Nine_second = new double[] {};
		private static double[] Nine_third = new double[] {};
		private static double[] Nine_fourth = new double[] {};	

		
		
	// left column
	// K, h, k, m, n, r
	// M, N, i, l, I, E, F, L, H
	// 
	public static char[] zeroLoop_leftColumn(HashMap<Integer, double[]> hMap) {
		
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[15];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], K_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], K_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], K_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], K_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'K');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], h_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], h_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], h_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], h_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'h');
		
		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], k_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], k_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], k_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], k_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'k');
		
		resultArr[2] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], m_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], m_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], m_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], m_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'm');
		
		resultArr[3] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], n_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], n_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], n_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], n_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'n');
		
		resultArr[4] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], r_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], r_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], r_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], r_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'r');
		
		resultArr[5] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], M_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], M_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], M_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], M_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'M');
		
		resultArr[6] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], N_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], N_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], N_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], N_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'N');
		
		resultArr[7] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], i_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], i_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], i_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], i_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'i');
		
		resultArr[8] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], l_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], l_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], l_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], l_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'l');
		
		resultArr[9] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], I_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], I_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], I_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], I_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'I');
		
		resultArr[10] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], E_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], E_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], E_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], E_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'E');
		
		resultArr[11] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], F_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], F_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], F_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], F_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'F');
		
		resultArr[12] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], L_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], L_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], L_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], L_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'L');
		
		resultArr[13] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], H_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], H_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], H_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], H_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'H');
		
		resultArr[14] = percentResult;
		
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);
		
		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}

	
	// c-shaped left side
	// C, G, c
	public static char[] zeroLoop_cCurve(HashMap<Integer, double[]> hMap) {
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[3];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], C_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], C_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], C_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], C_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'C');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], c_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], c_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], c_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], c_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'c');

		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], G_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], G_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], G_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], G_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'G');

		resultArr[2] = percentResult;
		
		//////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);

		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}
	

	// 70 degree
	// V, W, v , w
	public static char[] zeroLoop_vEdge(HashMap<Integer, double[]> hMap) {
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[3];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], V_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], V_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], V_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], V_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'V');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], W_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], W_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], W_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], W_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'W');

		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], v_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], v_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], v_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], v_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'v');

		resultArr[2] = percentResult;
		
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], w_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], w_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], w_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], w_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'w');

		resultArr[2] = percentResult;
		
		
		////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);

		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}
	

	// curves
	// J, j, S, s, U, a, f, u, 2, 3, 5
	
	// 90 degree angles
	// T, t, 4
	
	// X, Y, Z
	// x, y, z
	// 1, 7
	public static char[] zeroLoop_misc(HashMap<Integer, double[]> hMap) {
		
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[15];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], J_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], J_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], J_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], J_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'J');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], j_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], j_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], j_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], j_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'h');
		
		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], k_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], k_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], k_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], k_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'k');
		
		resultArr[2] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], m_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], m_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], m_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], m_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'm');
		
		resultArr[3] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], n_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], n_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], n_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], n_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'n');
		
		resultArr[4] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], r_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], r_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], r_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], r_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'r');
		
		resultArr[5] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], M_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], M_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], M_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], M_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'M');
		
		resultArr[6] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], N_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], N_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], N_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], N_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'N');
		
		resultArr[7] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], i_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], i_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], i_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], i_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'i');
		
		resultArr[8] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], l_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], l_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], l_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], l_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'l');
		
		resultArr[9] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], I_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], I_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], I_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], I_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'I');
		
		resultArr[10] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], E_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], E_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], E_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], E_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'E');
		
		resultArr[11] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], F_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], F_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], F_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], F_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'F');
		
		resultArr[12] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], L_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], L_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], L_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], L_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'L');
		
		resultArr[13] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], H_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], H_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], H_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], H_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'H');
		
		resultArr[14] = percentResult;
		
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);
		
		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}

	
	
	
	// c-shaped left side
	//c-shaped left side
	// e, o, O, Q, 6, 0
	public static char[] oneLoop_cCurve(HashMap<Integer, double[]> hMap) {
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[4];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], e_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], e_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], e_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], e_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'e');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], o_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], o_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], o_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], o_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'o');

		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], O_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], O_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], O_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], O_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'O');

		resultArr[2] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Q_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Q_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Q_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Q_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'Q');

		resultArr[3] = percentResult;
		
		
		//////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);

		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}
	
	
	//left column
	// D, P, R, b, p
	// 
	public static char[] oneLoop_leftColumn(HashMap<Integer, double[]> hMap) {
		
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[5];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], D_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], D_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], D_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], D_fourth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'D');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], P_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], P_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], P_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], P_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'P');
		
		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], R_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], R_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], R_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], R_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'R');
		
		resultArr[2] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], b_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], b_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], b_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], b_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'b');
		
		resultArr[3] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], p_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], p_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], p_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], p_fourth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,2);
		
		percentageHMap.put(percentResult, 'p');
		
		resultArr[4] = percentResult;
		
		/////////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);
		
		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}
		//////////////

		
		//right column
		// d, a,q
		// 
		public static char[] oneLoop_rightColumn(HashMap<Integer, double[]> hMap) {
			
			
			HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
			
			
			double[] resultArr = new double[3];
			
			double[] firstUnknown = hMap.get(0);
			double[] secondUnknown = hMap.get(1);
			double[] thirdUnknown = hMap.get(2);
			double[] fourthUnknown = hMap.get(3);
			
			double[] resultOne = new double[4];
			double[] resultTwo = new double[4];
			double[] resultThree = new double[4];
			double[] resultFour = new double[4];
			
			
			for (int i=0;i<4;i++) {
				resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], d_first[i]);
				resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], d_second[i]);
				resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], d_third[i]);
				resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], d_fourth[i]);
			}
			
			double o = 0.0;
			double t = 0.0;
			double thr = 0.0;
			double f = 0.0;
			
			for (int i=0;i<4;i++) {
				o+=resultOne[i];
			}
			for (int i=0;i<4;i++) {
				t+=resultTwo[i];
			}
			for (int i=0;i<4;i++) {
				thr+=resultThree[i];
			}
			for (int i=0;i<4;i++) {
				f+=resultFour[i];
			}
			
			o = o/4;
			t = t/4;
			thr = thr/4;
			f = f/4;
			
			double aver = (o+t+thr+f)/4;
			
			double percentResult = round(aver,2);
			
			percentageHMap.put(percentResult, 'd');
			
			resultArr[0] = percentResult;
			
			//////
			
			
			for (int i=0;i<4;i++) {
				resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], a_first[i]);
				resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], a_second[i]);
				resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], a_third[i]);
				resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], a_fourth[i]);
			}
			
			o = 0.0;
			t = 0.0;
			thr = 0.0;
			f = 0.0;
			
			for (int i=0;i<4;i++) {
				o+=resultOne[i];
			}
			for (int i=0;i<4;i++) {
				t+=resultTwo[i];
			}
			for (int i=0;i<4;i++) {
				thr+=resultThree[i];
			}
			for (int i=0;i<4;i++) {
				f+=resultFour[i];
			}
			
			o = o/4;
			t = t/4;
			thr = thr/4;
			f = f/4;
			
			aver = (o+t+thr+f)/4;
			
			percentResult = round(aver,2);
			
			percentageHMap.put(percentResult, 'a');
			
			resultArr[1] = percentResult;
			
			///////////
			
			for (int i=0;i<4;i++) {
				resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], q_first[i]);
				resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], q_second[i]);
				resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], q_third[i]);
				resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], q_fourth[i]);
			}
			
			o = 0.0;
			t = 0.0;
			thr = 0.0;
			f = 0.0;
			
			for (int i=0;i<4;i++) {
				o+=resultOne[i];
			}
			for (int i=0;i<4;i++) {
				t+=resultTwo[i];
			}
			for (int i=0;i<4;i++) {
				thr+=resultThree[i];
			}
			for (int i=0;i<4;i++) {
				f+=resultFour[i];
			}
			
			o = o/4;
			t = t/4;
			thr = thr/4;
			f = f/4;
			
			aver = (o+t+thr+f)/4;
			
			percentResult = round(aver,2);
			
			percentageHMap.put(percentResult, 'q');
			
			resultArr[2] = percentResult;
			
			
			//////////////
		
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);
		
		char[] temp = new char[5];
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) temp[4] = s.charAt(3);

		return temp;
	}

	
	
	
	

	private static double percentSimilarityBetweenTwoDoubles(double A, double B) {
		double result=0.0;
		if (A==0.0) {
			A=0.01;
		}
		if (B==0.0) {
			B=0.01;
		}
		
		if (A>B) {
			result = round((B/A),2);
		}
		else if (B>A) {
			result = round((A/B),2);
		}
		else result = 1.0;
		


		return result;
	}
	
	/*
	 * round up decimal values to 2 places
	 * */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public static void main(String[] args) {
		
		System.out.println(percentSimilarityBetweenTwoDoubles(0.0,0.0));
		
		System.out.println(percentSimilarityBetweenTwoDoubles(0.004,0.0));
		
		System.out.println(percentSimilarityBetweenTwoDoubles(0.0,0.004));
		
	}
	
	

}
